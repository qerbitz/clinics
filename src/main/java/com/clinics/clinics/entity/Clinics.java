package com.clinics.clinics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Przychodnia")
public class Clinics {

    @Id
    @Column(name = "id_przychodni")
    private int id_przychodni;

    @Column(name ="id_adresu")
    private Adress id_adresu;

    public Clinics(int id_przychodni, Adress id_adresu) {
        this.id_przychodni = id_przychodni;
        this.id_adresu = id_adresu;
    }

    public int getId_przychodni() {
        return id_przychodni;
    }

    public void setId_przychodni(int id_przychodni) {
        this.id_przychodni = id_przychodni;
    }

    public Adress getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(Adress id_adresu) {
        this.id_adresu = id_adresu;
    }

    @Override
    public String toString() {
        return "Clinics{" +
                "id_przychodni=" + id_przychodni +
                ", id_adresu=" + id_adresu +
                '}';
    }
}
