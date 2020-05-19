package com.clinics.clinics.entity;


import javax.persistence.*;

@Entity
@Table(name="specjalizacje")
public class Specialization {

    @Id
    @Column(name="id_specjalizacji")
    private int id_specialization;

    @Column(name="nazwa")
    private String name;

    public Specialization(int id_specialization, String name) {
        this.id_specialization = id_specialization;
        this.name = name;
    }

    public Specialization() {
    }

    public int getId_specjalizacji() {
        return id_specialization;
    }

    public void setId_specjalizacji(int id_specjalizacji) {
        this.id_specialization = id_specjalizacji;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Specialization{" +
                "id_specjalizacji=" + id_specialization +
                ", name='" + name + '\'' +
                '}';
    }
}
