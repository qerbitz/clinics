package com.clinics.clinics.entity;

import javax.persistence.*;

@Entity
@Table(name="specjalizacja_lekarz")
public class Specialization_doctor {

    @Id
    @Column(name = "ajdi")
    private int ajdi;

    @ManyToOne
    @JoinColumn(name="id_lekarza")
    private Doctors id_doctor;

    @ManyToOne
    @JoinColumn(name="id_specjalizacji")
    private Specialization specialization;

    public Specialization_doctor(Doctors id_doctor, Specialization specialization) {
        this.id_doctor = id_doctor;
        this.specialization = specialization;
    }

    public Specialization_doctor(){

    }

    public Doctors getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(Doctors id_doctor) {
        this.id_doctor = id_doctor;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Specialization_doctor{" +
                "id_doctor=" + id_doctor +
                ", specialization=" + specialization +
                '}';
    }
}
