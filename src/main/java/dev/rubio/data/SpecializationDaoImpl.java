package dev.rubio.data;

import dev.rubio.models.Specialization;
import dev.rubio.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SpecializationDaoImpl implements SpecializationDao {
    @Override
    public List<Specialization> getAllSpecializations(){return null;}

    @Override
    public Specialization createSpecialization(Specialization newSpecialization){
        try(Session s = HibernateUtil.getSession()){
            Transaction tx = s.beginTransaction();
            String specialty = (String) s.save(newSpecialization);
            newSpecialization.setSpecialty(specialty);
            tx.commit();
            return newSpecialization;
        }
    }
}
