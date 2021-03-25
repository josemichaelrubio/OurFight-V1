package dev.rubio.services;

import dev.rubio.data.DoctorDaoHibImpl;
import dev.rubio.data.DoctorDaoImpl;
import dev.rubio.data.DoctorDao;
import dev.rubio.models.Doctor;

import java.util.List;

public class DoctorService {

    private DoctorDao doctorDao = new DoctorDaoHibImpl();

    public List<Doctor> getAll(){ return doctorDao.getAllDoctors(); }
    public List<Doctor> getSpecialty(){ return doctorDao.getDoctorsBySpecialty();}
    public List<Doctor> getPsychiatrists(){ return doctorDao.getPsychiatrists();}
    public List<Doctor> getChildPsychologists() { return doctorDao.getChildPsychologists();}
    public List<Doctor> getMarriageCounselors(){return doctorDao.getMarriageCounselors();}
    public Doctor add(Doctor doctor){
        return doctorDao.addNewDoctor(doctor);
    }
    public void delete(int id){doctorDao.deleteDoctor(id);}

    // attempt to delete doctor by Id and name
    /*
    public void delete(int id, String name){
        doctorDao.deleteOldDoctor(id,name);
    }
     */


}
