package dev.rubio.hib;

import dev.rubio.data.SpecializationDao;
import dev.rubio.data.SpecializationDaoImpl;
import dev.rubio.models.Specialization;

import java.math.BigDecimal;

public class SpecHibDriver {
    public static void main(String[] args) {
        SpecializationDao sDao = new SpecializationDaoImpl();
        Specialization spec = new Specialization("Psychiatry", new BigDecimal(50.00));
        sDao.createSpecialization(spec);
        Specialization spec1 = new Specialization("Child Psychology", new BigDecimal(25.00));
        sDao.createSpecialization(spec1);
        Specialization spec3 = new Specialization("Therapy", new BigDecimal(25.00));
        sDao.createSpecialization(spec3);
        Specialization spec4 = new Specialization("Group Therapy", new BigDecimal(15.00));
        sDao.createSpecialization(spec4);
        Specialization spec5 = new Specialization("Marriage Counseling", new BigDecimal(25.00));
        sDao.createSpecialization(spec5);

        // Within the Hib Driver
    }
}
