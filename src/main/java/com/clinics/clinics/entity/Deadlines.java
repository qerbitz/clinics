package com.clinics.clinics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "Terminy")
public class Deadlines {

    @Id
    @Column(name = "id_terminu")
    private int id_deadline;

    @Column(name = "data")
    private Date date;

    @Column(name = "czas_od")
    private Time time_from;

    @Column(name = "czas_do")
    private Time time_to;

    public Deadlines(int id_deadline, Date date, Time time_from, Time time_to) {
        this.id_deadline = id_deadline;
        this.date = date;
        this.time_from = time_from;
        this.time_to = time_to;
    }

    public int getId_deadline() {
        return id_deadline;
    }

    public void setId_deadline(int id_deadline) {
        this.id_deadline = id_deadline;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime_from() {
        return time_from;
    }

    public void setTime_from(Time time_from) {
        this.time_from = time_from;
    }

    public Time getTime_to() {
        return time_to;
    }

    public void setTime_to(Time time_to) {
        this.time_to = time_to;
    }

    @Override
    public String toString() {
        return "Deadlines{" +
                "id_deadline=" + id_deadline +
                ", date=" + date +
                ", time_from=" + time_from +
                ", time_to=" + time_to +
                '}';
    }
}
