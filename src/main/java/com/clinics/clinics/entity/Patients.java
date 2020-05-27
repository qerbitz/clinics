package com.clinics.clinics.entity;


import javax.persistence.*;

@Entity
@Table(name="Pacjenci")
public class Patients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pacjenta")
    private int id_patient;

    @Column(name="pesel")
    private String pesel;

    @Column(name="imie")
    private String name;

    @Column(name="nazwisko")
    private String surname;

    @Column(name="telefon")
    private String phone;

    @OneToOne
    @JoinColumn(name="id_adresu")
    private Adress adres;

    public Patients() {
    }

    public Patients(int id_pacjenta, String pesel, String name, String surname, String phone, Adress adres) {
        this.id_patient = id_pacjenta;
        this.pesel = pesel;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.adres = adres;
    }

    public int getId_patient() {
        return id_patient;
    }

    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
                "id_pacjenta=" + id_patient +
                ", pesel='" + pesel + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", adres=" + adres +
                '}';
    }
}

