package com.clinics.clinics.entity;


import javax.persistence.*;

@Entity
@Table(name="lekarze")
public class Doctors {

    @Id
    @Column(name="id_lekarza")
    private int id_doctor;

    @Column(name="imie")
    private String name;

    @Column(name="nazwisko")
    private String surname;

    @Column(name="pesel")
    private String pesel;

    @OneToOne
    @JoinColumn(name="id_adresu")
    private Adress adress;

    @Column(name="nr_gabinetu")
    private String nr_office;

    public Doctors(){

    }

    public Doctors(int id_doctor, String name, String surname, String pesel, Adress adress, String nr_office) {
        this.id_doctor = id_doctor;
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.adress = adress;
        this.nr_office = nr_office;
    }

    public int getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(int id_doctor) {
        this.id_doctor = id_doctor;
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

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getNr_office() {
        return nr_office;
    }

    public void setNr_office(String nr_office) {
        this.nr_office = nr_office;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Doctors{" +
                "id_doctor=" + id_doctor +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", pesel='" + pesel + '\'' +
                ", adress=" + adress +
                ", nr_office='" + nr_office + '\'' +
                '}';
    }
}


