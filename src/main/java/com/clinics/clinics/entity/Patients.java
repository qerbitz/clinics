package com.clinics.clinics.entity;


import javax.persistence.*;

@Entity
@Table(name="Pacjenci")
public class Patients {

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

    @OneToOne
    @JoinColumn(name="id_adresu")
    private Adress adres;

    public Patients(int id_pacjenta, String pesel, String imie, String nazwisko, String telefon, Adress adres) {
        this.id_pacjenta = id_pacjenta;
        this.pesel = pesel;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
        this.adres = adres;
    }

    public Patients()
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

    public Adress getAdres() {
        return adres;
    }

    public void setAdres(Adress adres) {
        this.adres = adres;
    }

    @Override
    public String toString() {
        return "Patients{" +
                "id_pacjenta=" + id_pacjenta +
                ", pesel='" + pesel + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", telefon='" + telefon + '\'' +
                ", adres=" + adres +
                '}';
    }
}

