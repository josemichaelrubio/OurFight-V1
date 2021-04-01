package dev.rubio.data;

import dev.rubio.models.Doctor;
import dev.rubio.util.HibernateUtil;
import org.hibernate.Session; // I think this is the correct import
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DoctorDaoHibImpl implements DoctorDao{

    private final Logger logger = LoggerFactory.getLogger(DoctorDaoHibImpl.class);
    @Override
    public List<Doctor> getAllDoctors() {
        try(Session s = HibernateUtil.getSession()){
            List<Doctor> doctors = s.createQuery("from Doctor",Doctor.class).list();
            return doctors;
        }

    }
    public List<Doctor> getTherapists(){
        try(Session s = HibernateUtil.getSession()){
            List<Doctor> doctors = s.createQuery("from Doctor where specialty = 'Therapy'", Doctor.class).list();
            return doctors;
        }
    }

//    @Override
//    public List<Doctor> getDoctorsBySpecialty() {
//        return null;
//    }

    @Override
    public List<Doctor> getPsychiatrists() {
        try(Session s = HibernateUtil.getSession()){
            List<Doctor> doctors = s.createQuery("from Doctor where specialty = 'Psychiatry'", Doctor.class).list();
            return doctors;
        }
    }

    @Override
    public List<Doctor> getChildPsychologists() {
        try(Session s = HibernateUtil.getSession()) {
            List<Doctor> doctors = s.createQuery("from Doctor where specialty_specialty = 'Child Psychology'", Doctor.class).list();
            return doctors;
        }
    }

    @Override
    public List<Doctor> getMarriageCounselors() {
            try(Session s = HibernateUtil.getSession()) {
                List<Doctor> doctors = s.createQuery("from Doctor where specialty_specialty = 'Marriage Counseling'", Doctor.class).list();
                return doctors;
            }
    }

    @Override
    public List<Doctor> getGroupTherapists(){
        try(Session s = HibernateUtil.getSession()){
            List<Doctor> doctors = s.createQuery("from Doctor where specialty = 'Group Therapy'", Doctor.class).list();
            return doctors;
        }
    }

    @Override
    public Doctor addNewDoctor(Doctor doctor) {
        try(Session s = HibernateUtil.getSession()){
            Transaction tx = s.beginTransaction();
            //s.persist(doctor);
            int id =(int) s.save(doctor);
            doctor.setId(id);
            logger.info("added new item with id:"+id);
            tx.commit();
            return doctor;
        }

    }



    @Override
    public void deleteDoctor(String id) {
        try(Session s = HibernateUtil.getSession()){
            Transaction tx = s.beginTransaction();
            s.delete(new Doctor(id));
            tx.commit();
        }
    }
}
