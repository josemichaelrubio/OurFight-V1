package dev.rubio.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name="specialization")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Specialization {
    @Id
    private String specialty;
    private BigDecimal coPay;
    // stopped here



    public Specialization(String specialty, BigDecimal coPay){
        this.specialty = specialty;
        this.coPay = coPay;
    }

    public Specialization() {
        super();
    }

    public Specialization(String specialty){
        this.specialty = specialty;
    }




    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public BigDecimal getCoPay() {
        return coPay;
    }

    public void setCoPay(BigDecimal coPay) {
        this.coPay = coPay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specialization that = (Specialization) o;
        return Objects.equals(specialty, that.specialty) && Objects.equals(coPay, that.coPay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specialty, coPay);
    }

    @Override
    public String toString() {
        return "Specialization{" +
                "specialty='" + specialty + '\'' +
                ", coPay=" + coPay +
                '}';
    }
}
