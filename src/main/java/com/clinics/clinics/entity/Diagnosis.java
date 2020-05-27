package com.clinics.clinics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Diagnozy")
public class Diagnosis {

    @Id
    @Column(name = "id_diagnozy")
    private int id_diagnosis;

    @Column(name = "nazwa")
    private String name;

    @Column(name = "opis")
    private String description;

    public Diagnosis(int id_diagnosis, String name, String description) {
        this.id_diagnosis = id_diagnosis;
        this.name = name;
        this.description = description;
    }

    public Diagnosis(){

    }

    public int getId_diagnosis() {
        return id_diagnosis;
    }

    public void setId_diagnosis(int id_diagnosis) {
        this.id_diagnosis = id_diagnosis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Diagnosis{" +
                "id_diagnosis=" + id_diagnosis +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
