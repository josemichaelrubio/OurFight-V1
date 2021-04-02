package dev.rubio;

import dev.rubio.controllers.AuthController;
import dev.rubio.controllers.DoctorController;
import dev.rubio.util.SecurityUtil;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;


import static io.javalin.apibuilder.ApiBuilder.*;
import static io.javalin.apibuilder.ApiBuilder.post;

public class Driver {


    public static void main(String[] args) {



        Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins).start(80); //establishing a connection with Javalin
        app.get("/", ctx -> ctx.result("Welcome to Our Fight!"));

        SecurityUtil securityUtil = new SecurityUtil();
        DoctorController doctorController = new DoctorController();
        AuthController authController = new AuthController();

        app.routes(()->{
            path("doctors",()->{
                before("/",authController::userToken);
                get(doctorController::handleGetDoctorsRequest);
                post(doctorController::handlePostNewDoctor);
                path(":id",()->{
                    before("/", authController::userToken);
                    delete(doctorController::handleDeleteDoctorById);
                });
                delete(doctorController::handleDeleteDoctorById);
                path("therapists",()->{
                   before("/", authController::userToken);
                   get(doctorController:: handleGetTherapists);

                });

                path("psychiatrists", ()->{
                    before("/", authController::userToken);
                    get(doctorController::handleGetPsychiatrists);

                });
                path("child-psychologists", ()->{
                    before("/",authController::userToken);
                    get(doctorController::handleGetChildPsychologists);
                });
                path("marriage-counselors", ()->{
                    before("/", authController::userToken);
                    get(doctorController::handleGetMarriageCounselors);
                });
                path("group-therapists", ()->{
                    before("/", authController::userToken);
                    get(doctorController::handleGetGroupTherapists);
                });


            });
            //path("login", ()-> {
//                post(authController::authenticateLogin)
////                after("/", securityUtil::attachResoinseHeaders); ////////////////////////////////////
//                    });
//            );
            path("login", ()->{
                    post(authController::authenticateLogin);
                    after("/",securityUtil::attachResponseHeaders);
            });
        });



    }


}




