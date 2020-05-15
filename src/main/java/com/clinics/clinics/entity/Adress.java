package com.clinics.clinics.entity;

import javax.persistence.*;


@Entity
@Table(name="adresy")
public class Adress {

    @Id
    @Column(name="id_adresu")
    private int id_adress;

    @Column(name="miejscowosc")
    private String place;

    @Column(name="wojewodztwo")
    private String voivodeship;

    @Column(name="powiat")
    private String county;

    @Column(name="ulica")
    private String street;

    @Column(name="nr_domu")
    private String nr_house;

    @Column(name="kod_pocztowy")
    private String zip_code;

    public Adress(int id_adress, String place, String voivodeship, String county, String street, String nr_house, String zip_code) {
        this.id_adress = id_adress;
        this.place = place;
        this.voivodeship = voivodeship;
        this.county = county;
        this.street = street;
        this.nr_house = nr_house;
        this.zip_code = zip_code;
    }

    public int getId_adress() {
        return id_adress;
    }

    public void setId_adress(int id_adress) {
        this.id_adress = id_adress;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getVoivodeship() {
        return voivodeship;
    }

    public void setVoivodeship(String voivodeship) {
        this.voivodeship = voivodeship;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNr_house() {
        return nr_house;
    }

    public void setNr_house(String nr_house) {
        this.nr_house = nr_house;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "id_adress=" + id_adress +
                ", place='" + place + '\'' +
                ", voivodeship='" + voivodeship + '\'' +
                ", county='" + county + '\'' +
                ", street='" + street + '\'' +
                ", nr_house='" + nr_house + '\'' +
                ", zip_code='" + zip_code + '\'' +
                '}';
    }
}
