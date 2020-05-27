package com.clinics.clinics.entity;

import javax.persistence.*;

@Entity
@Table(name = "Przychodnia")
public class Clinics {

    @Id
    @Column(name = "id_przychodni")
    private int id_clinic;

    @ManyToOne
    @JoinColumn(name ="id_adresu")
    private Adress id_adresu;

    public Clinics(int id_clinic, Adress id_adresu) {
        this.id_clinic = id_clinic;
        this.id_adresu = id_adresu;
    }

    public Clinics(){

    }

    public int getId_clinic() {
        return id_clinic;
    }

    public void setId_clinic(int id_przychodni) {
        this.id_clinic = id_przychodni;
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
                "id_przychodni=" + id_clinic +
                ", id_adresu=" + id_adresu +
                '}';
    }
}
