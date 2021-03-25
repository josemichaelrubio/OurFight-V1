package dev.rubio.data;

import dev.rubio.models.Doctor;
import dev.rubio.util.HibernateUtil;
import org.hibernate.Session; // I think this is the correct import

import java.util.List;

public class DoctorDaoHibImpl implements DoctorDao{
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
        return null;
    }

    @Override
    public void deleteDoctor(int id) {

    }
}
