package com.clinics.clinics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name="Specjalizacja_lekarz")
public class Specjalizacja_lekarz {

    //@Column(name="id_adresu")
    private Adresy adres;

    //@Column(name="id_specjalizacji")
    private Specjalizacje specjalizacje;

    public Adresy getAdres() {
        return adres;
    }

    public void setAdres(Adresy adres) {
        this.adres = adres;
    }

    public Specjalizacje getSpecjalizacje() {
        return specjalizacje;
    }

    public void setSpecjalizacje(Specjalizacje specjalizacje) {
        this.specjalizacje = specjalizacje;
    }

    public Specjalizacja_lekarz(Adresy adres, Specjalizacje specjalizacje) {
        this.adres = adres;
        this.specjalizacje = specjalizacje;
    }

    @Override
    public String toString() {
        return "Specjalizacja_lekarz{" +
                "adres=" + adres +
                ", specjalizacje=" + specjalizacje +
                '}';
    }
}
