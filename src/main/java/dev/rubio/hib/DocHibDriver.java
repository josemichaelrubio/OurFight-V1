package dev.rubio.hib;

import dev.rubio.data.DoctorDao;
import dev.rubio.data.DoctorDaoHibImpl;
import dev.rubio.models.Doctor;
import dev.rubio.models.Specialization;

public class DocHibDriver {
    public static void main(String[] args) {
        DoctorDao dDao = new DoctorDaoHibImpl();
        Doctor doc = new Doctor("Jeffery Rose", new Specialization("Psychiatry"), "Male", true, true );

    }

}
