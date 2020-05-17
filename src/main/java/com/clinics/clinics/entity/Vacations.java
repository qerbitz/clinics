package com.clinics.clinics.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "Urlopy")
public class Vacations {

    @Id
    @Column(name = "id_urlopu")
    private int id_vacation;

    @Column(name = "data_od")
    private Date date_from;

    @Column(name = "data_do")
    private Date date_to;

    @ManyToOne
    @JoinColumn(name="id_lekarza")
    private Doctors id_doctor;

    public Vacations(int id_vacation, Date date_from, Date date_to, Doctors id_doctor) {
        this.id_vacation = id_vacation;
        this.date_from = date_from;
        this.date_to = date_to;
        this.id_doctor = id_doctor;
    }

    public int getId_vacation() {
        return id_vacation;
    }

    public void setId_vacation(int id_vacation) {
        this.id_vacation = id_vacation;
    }

    public Date getDate_from() {
        return date_from;
    }

    public void setDate_from(Date date_from) {
        this.date_from = date_from;
    }

    public Date getDate_to() {
        return date_to;
    }

    public void setDate_to(Date date_to) {
        this.date_to = date_to;
    }

    public Doctors getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(Doctors id_doctor) {
        this.id_doctor = id_doctor;
    }

    @Override
    public String toString() {
        return "Vacations{" +
                "id_vacation=" + id_vacation +
                ", date_from=" + date_from +
                ", date_to=" + date_to +
                ", id_doctor=" + id_doctor +
                '}';
    }
}
