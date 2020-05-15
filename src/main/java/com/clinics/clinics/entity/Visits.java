package com.clinics.clinics.entity;

import javax.persistence.*;

@Entity
@Table(name ="Wizyty")
public class Visits {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_wizyty")
    private int id_visit;

    @Column(name="id_diagnozy")
    private Diagnosis id_diagnosis;

    @Column(name="id_terminu")
    private Deadlines id_deadline;

    @Column(name="id_przychodni")
    private Clinics id_clinics;

    @Column(name="id_lekarza")
    private Doctors id_doctor;

    @Column(name="id_pacjenta")
    private Patients id_patient;

    public Visits(int id_visit, Diagnosis id_diagnosis, Deadlines id_deadline, Clinics id_clinics, Doctors id_doctor, Patients id_patient) {
        this.id_visit = id_visit;
        this.id_diagnosis = id_diagnosis;
        this.id_deadline = id_deadline;
        this.id_clinics = id_clinics;
        this.id_doctor = id_doctor;
        this.id_patient = id_patient;
    }

    public int getId_visit() {
        return id_visit;
    }

    public void setId_visit(int id_visit) {
        this.id_visit = id_visit;
    }

    public Diagnosis getId_diagnosis() {
        return id_diagnosis;
    }

    public void setId_diagnosis(Diagnosis id_diagnosis) {
        this.id_diagnosis = id_diagnosis;
    }

    public Deadlines getId_deadline() {
        return id_deadline;
    }

    public void setId_deadline(Deadlines id_deadline) {
        this.id_deadline = id_deadline;
    }

    public Clinics getId_clinics() {
        return id_clinics;
    }

    public void setId_clinics(Clinics id_clinics) {
        this.id_clinics = id_clinics;
    }

    public Doctors getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(Doctors id_doctor) {
        this.id_doctor = id_doctor;
    }

    public Patients getId_patient() {
        return id_patient;
    }

    public void setId_patient(Patients id_patient) {
        this.id_patient = id_patient;
    }

    @Override
    public String toString() {
        return "Visits{" +
                "id_visit=" + id_visit +
                ", id_diagnosis=" + id_diagnosis +
                ", id_deadline=" + id_deadline +
                ", id_clinics=" + id_clinics +
                ", id_doctor=" + id_doctor +
                ", id_patient=" + id_patient +
                '}';
    }
}
