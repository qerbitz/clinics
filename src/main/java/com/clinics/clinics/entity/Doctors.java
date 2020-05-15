package com.clinics.clinics.entity;


import javax.persistence.*;

@Entity
@Table(name="Lekarze")
public class Doctors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_lekarza")
    private int id_doctor;

    @Column(name="pesel")
    private String pesel;

    @Column(name="imie")
    private String name;

    @Column(name="nazwisko")
    private String surname;

    @Column(name="id_adresu")
    private Adress adress;

    @Column(name="nr_gabinetu")
    private int nr_office;

    public Doctors(int id_doctor, String pesel, String name, String surname, Adress adress, int nr_office) {
        this.id_doctor = id_doctor;
        this.pesel = pesel;
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.nr_office = nr_office;
    }

    public Doctors() {
    }

    public int getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(int id_doctor) {
        this.id_doctor = id_doctor;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public int getNr_office() {
        return nr_office;
    }

    public void setNr_office(int nr_office) {
        this.nr_office = nr_office;
    }

    @Override
    public String toString() {
        return "Doctors{" +
                "id_doctor=" + id_doctor +
                ", pesel='" + pesel + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", adress=" + adress +
                ", nr_office=" + nr_office +
                '}';
    }
}


