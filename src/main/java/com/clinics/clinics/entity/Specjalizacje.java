package com.clinics.clinics.entity;


import javax.persistence.*;

@Entity
@Table(name="specjalizacje")
public class Specjalizacje {

    @Id
    @Column(name="id_specjalizacji")
    private int id_specjalizacji;

    @Column(name="nazwa")
    private String nazwa;

    public Specjalizacje(String nazwa) {
        this.nazwa = nazwa;
    }

    public Specjalizacje()
    {

    }

    public int getId_specjalizacji() {
        return id_specjalizacji;
    }

    public void setId_specjalizacji(int id_specjalizacji) {
        this.id_specjalizacji = id_specjalizacji;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "Specjalizacje{" +
                "id_specjalizacji=" + id_specjalizacji +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }
}
