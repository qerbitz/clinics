package com.clinics.clinics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Leki")
public class Medicines {

    @Id
    @Column (name = "id_leku")
    private int id_medicine;

    @Column (name = "nazwa_leku")
    private String name;

    public Medicines(int id_medicine, String name_medicine) {
        this.id_medicine = id_medicine;
        this.name = name_medicine;
    }

    public Medicines(){

    }

    public int getId_medicine() {
        return id_medicine;
    }

    public void setId_medicine(int id_medicine) {
        this.id_medicine = id_medicine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name_medicine) {
        this.name = name_medicine;
    }

    @Override
    public String toString() {
        return "Medicines{" +
                "id_medicine=" + id_medicine +
                ", name_medicine='" + name + '\'' +
                '}';
    }
}
