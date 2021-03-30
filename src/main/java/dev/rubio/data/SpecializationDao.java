package dev.rubio.data;

import dev.rubio.models.Specialization;

import java.util.List;

public interface SpecializationDao {
    public List<Specialization> getAllSpecializations();
    public Specialization createSpecialization(Specialization newSpecialization);
}
