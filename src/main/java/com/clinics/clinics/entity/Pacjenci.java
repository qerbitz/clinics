package com.clinics.clinics.entity;


import javax.persistence.*;

//@Entity
//@Table(name="pacjenci")
public class Pacjenci {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id_pacjenta;

    @Column(name="pesel")
    private String pesel;

    @Column(name="imie")
    private String imie;

    @Column(name="nazwisko")
    private String nazwisko;

    @Column(name="telefon")
    private String telefon;

    @Column(name="id_adresu")
    private Adresy adres;

    public Pacjenci(int id_pacjenta, String pesel, String imie, String nazwisko, String telefon, Adresy adres) {
        this.id_pacjenta = id_pacjenta;
        this.pesel = pesel;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
        this.adres = adres;
    }

    public Pacjenci()
    {

    }

    public int getId_pacjenta() {
        return id_pacjenta;
    }

    public void setId_pacjenta(int id_pacjenta) {
        this.id_pacjenta = id_pacjenta;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Adresy getAdres() {
        return adres;
    }

    public void setAdres(Adresy adres) {
        this.adres = adres;
    }
}

