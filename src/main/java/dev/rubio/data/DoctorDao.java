package dev.rubio.data;

import dev.rubio.models.Doctor;

import java.util.List;

public interface DoctorDao {
    public List<Doctor> getAllDoctors();
    public List<Doctor> getDoctorsBySpecialty();
    public List<Doctor> getPsychiatrists();
    public List<Doctor> getChildPsychologists();
    public List<Doctor> getMarriageCounselors();
    Doctor addNewDoctor(Doctor doctor);
    void deleteDoctor(int id);

    // Attempt to delete doctor by ID and Name
    /*
    void deleteOldDoctor(int id, String name);

     */

}
