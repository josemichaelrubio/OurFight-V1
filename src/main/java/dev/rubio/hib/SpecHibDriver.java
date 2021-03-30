package dev.rubio.hib;

import dev.rubio.data.SpecializationDao;
import dev.rubio.data.SpecializationDaoImpl;
import dev.rubio.models.Specialization;

import java.math.BigDecimal;

public class SpecHibDriver {
    public static void main(String[] args) {
        SpecializationDao sDao = new SpecializationDaoImpl();
        Specialization spec = new Specialization("Psychiatry", new BigDecimal(3));

        sDao.createSpecialization(spec);

        // Within the Hib Driver
    }
}
