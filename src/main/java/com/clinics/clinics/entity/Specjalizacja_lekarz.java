package com.clinics.clinics.entity;

//@Entity
//@Table(name="Specjalizacja_lekarz")
public class Specjalizacja_lekarz {

    //@Column(name="id_adresu")
    private Adress adres;

    //@Column(name="id_specjalizacji")
    private Specjalizacje specjalizacje;

    public Adress getAdres() {
        return adres;
    }

    public void setAdres(Adress adres) {
        this.adres = adres;
    }

    public Specjalizacje getSpecjalizacje() {
        return specjalizacje;
    }

    public void setSpecjalizacje(Specjalizacje specjalizacje) {
        this.specjalizacje = specjalizacje;
    }

    public Specjalizacja_lekarz(Adress adres, Specjalizacje specjalizacje) {
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
