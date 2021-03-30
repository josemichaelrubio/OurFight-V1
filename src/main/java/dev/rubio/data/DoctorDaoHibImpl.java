package dev.rubio.data;

import dev.rubio.models.Doctor;
import dev.rubio.models.Specialization;
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

    @Override
    public List<Doctor> getDoctorsBySpecialty() {
        return null;
    }

    @Override
    public List<Doctor> getPsychiatrists() {
        return null;
    }

    @Override
    public List<Doctor> getChildPsychologists() {
        return null;
    }

    @Override
    public List<Doctor> getMarriageCounselors() {
        return null;
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
    public void deleteDoctor(int id) {

    }
}
