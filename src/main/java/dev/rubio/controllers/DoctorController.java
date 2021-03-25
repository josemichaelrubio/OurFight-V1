package dev.rubio.controllers;

import dev.rubio.models.Doctor;
import dev.rubio.services.DoctorService;
import io.javalin.http.BadRequestResponse;
import io.javalin.http.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class DoctorController {

    private Logger logger = LoggerFactory.getLogger(DoctorController.class);
    private DoctorService service = new DoctorService();

    public void handleGetDoctorsRequest(Context ctx) {
        logger.info("getting all doctors");
        ctx.json(service.getAll());
    }

    public void handleGetSpecialtyDoctors(Context ctx) {
        logger.info("Getting specialty doctors ");
        ctx.json(service.getSpecialty());
    }

    public void handleGetPsychiatrists(Context ctx) {
        logger.info("Getting Psychiatrists");
        ctx.json(service.getPsychiatrists());
    }

    public void handleGetChildPsychologists(Context ctx) {
        logger.info("Getting Child Psychologists");
        ctx.json(service.getChildPsychologists());
    }

    public void handleGetMarriageCounselors(Context ctx) {
        logger.info("Getting Marriage Counselors");
        ctx.json(service.getMarriageCounselors());
    }

    public void handlePostNewDoctor(Context ctx) {
        Doctor doctor = ctx.bodyAsClass(Doctor.class);
        logger.info("Adding a new Doctor: {}", doctor);
        service.add(doctor);
        ctx.status(201);
    }

    public void handleDeleteDoctorById(Context ctx){
        String idString = ctx.pathParam("id");
        if (idString.matches("^\\d+$")){
            int idInput = Integer.parseInt(idString);
            logger.info("Deleting Record with Id: {}", idInput);
            service.delete(idInput);
        }
        else {
            throw new BadRequestResponse("input \"" +idString+"\" cannot be parsed to an int");
        }
    }

    // attempt to delete doctor by Id and Name
    /*

    public void handleDeleteByIdAndName(Context ctx) {
        String idString = ctx.pathParam("id");
        String nameString = ctx.pathParam("name");
        if (idString.matches("^\\d+$") || nameString.matches("^\\d+$")) {
            int idInput = Integer.parseInt(idString);
            logger.info("Deleting Record with Id: {}", idInput + " and name: {}",  nameString);
            service.delete(idInput, idString);
        } else {
            throw new BadRequestResponse("input \"" + idString + "\" cannot be parsed to an int");
        }
    }

     */
}
