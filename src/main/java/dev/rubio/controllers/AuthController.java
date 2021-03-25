

package dev.rubio.controllers;

import io.javalin.http.Context;
import io.javalin.http.UnauthorizedResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthController {
    private Logger logger = LoggerFactory.getLogger(AuthController.class);
    private Context ctx;



    public void authenticateLogin(Context ctx) {
        String user = ctx.formParam("username");
        String pass = ctx.formParam("password");
        logger.info(user + " attempted login");
        if (user != null && user.equals("username")) {
            if (pass != null && pass.equals("ourfight")) {
                logger.info("successful login");
                ctx.header("Authorization", "you-can-do-it");
                ctx.status(200);
                System.out.println("You have successfully login " + user);
                return;
            }
            throw new UnauthorizedResponse("Incorrect username and password");
        }
        throw new UnauthorizedResponse("Username not recognized");
    }


    public void userToken(Context ctx){
        String user = ctx.formParam("username"); //x-www-form-urlencoded
        logger.info("Authorizing token for" + user);
        if(ctx.method().equals("OPTIONS")){ //makes a request to the server and the response is what requests are available to use
            return;
        }
        String authHeader = ctx.header("Authorization");
        if(authHeader!=null && authHeader.equals("you-can-do-it")) {
            logger.info(user + " is a user and is authorized");
        }
        else {
            logger.warn(user +" is unauthorized");
            throw new UnauthorizedResponse();
        }
    }
    public void authenticateAdmin(Context ctx) {
        String user = ctx.formParam("username");
        String pass = ctx.formParam("password");
        logger.info(user + " attempted administrative login");
        if (user != null && user.equals("admin")) {
            if (pass != null && pass.equals("123")) {
                logger.info("successful login");
                ctx.header("Authorization", "admin-token");
                ctx.status(200);
                System.out.println("You have successfully login as an admin ");
                return;
            }
        } throw new UnauthorizedResponse("Incorrect username and password");
    }
    public void adminToken(Context ctx){
        String user = ctx.formParam("username");
        logger.info("Authorizing token for admin");
        String authHeader = ctx.header("Authorization");
        if(authHeader!= null && authHeader.equals("admin-auth-token")){
            logger.info(user + ";and admin is authorized");
        }
        else{
            logger.warn(user + " is an unauthorized admin");
        }


    }


}

