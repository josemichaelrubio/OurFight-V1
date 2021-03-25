package dev.rubio.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name= "doctor")
public class Doctor implements Serializable {
    @Id //determines primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto incrementing, behaves like a serial datatype
    private int id;
    private String name;
    private String specialty;
    private String gender;
    private boolean available;
    private boolean volunteer;
// Columns are auto generated for these ^

    public Doctor(){
        super();
    }


    public Doctor(int id, String name, String specialty, String gender, boolean available, boolean volunteer){
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.gender = gender;
        this.available = available;
        this.volunteer = volunteer;
    }

    public Doctor(String specialty, boolean available, String name, String gender) {
        this.specialty = specialty;
        this.available= available;
        this.name = name;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }


    public boolean isVolunteer() {
        return volunteer;
    }

    public void setVolunteer(boolean volunteer) {
        this.volunteer = volunteer;
    }



        @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return id == doctor.id && available == doctor.available && volunteer == doctor.volunteer && Objects.equals(name, doctor.name) && Objects.equals(specialty, doctor.specialty) && Objects.equals(gender, doctor.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, specialty, gender, available, volunteer);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specialty='" + specialty + '\'' +
                ", gender='" + gender + '\'' +
                ", available=" + available +
                ", volunteer=" + volunteer +
                '}';
    }
}

