package dev.rubio.data;

import dev.rubio.models.Doctor;

import java.util.List;

public interface DoctorDao {
    public List<Doctor> getAllDoctors();
    public List<Doctor> getTherapists();

//    public List<Doctor> getDoctorsBySpecialty();
    public List<Doctor> getPsychiatrists();
    public List<Doctor> getChildPsychologists();
    public List<Doctor> getMarriageCounselors();
    public List<Doctor> getGroupTherapists();
    Doctor addNewDoctor(Doctor doctor);
    void deleteDoctor(String id);

    // Attempt to delete doctor by ID and Name
    /*
    void deleteOldDoctor(int id, String name);

     */

}
