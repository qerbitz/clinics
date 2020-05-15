package com.clinics.clinics.entity;

import javax.persistence.*;


@Entity
@Table(name="adresy")
public class Adresy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_adresu")
    private int id_adresu;

    @Column(name="miejscowosc")
    private String miejscowosc;

    @Column(name="wojewodztwo")
    private String wojewodztwo;

    @Column(name="powiat")
    private String powiat;

    @Column(name="ulica")
    private String ulica;

    @Column(name="nr_domu")
    private String nr_domu;

    @Column(name="kod_pocztowy")
    private String kod_pocztowy;

    public Adresy(String miejscowosc, String wojewodztwo, String powiat, String ulica, String nr_domu, String kod_pocztowy) {
        this.miejscowosc = miejscowosc;
        this.wojewodztwo = wojewodztwo;
        this.powiat = powiat;
        this.ulica = ulica;
        this.nr_domu = nr_domu;
        this.kod_pocztowy = kod_pocztowy;
    }

    public int getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getWojewodztwo() {
        return wojewodztwo;
    }

    public void setWojewodztwo(String wojewodztwo) {
        this.wojewodztwo = wojewodztwo;
    }

    public String getPowiat() {
        return powiat;
    }

    public void setPowiat(String powiat) {
        this.powiat = powiat;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNr_domu() {
        return nr_domu;
    }

    public void setNr_domu(String nr_domu) {
        this.nr_domu = nr_domu;
    }

    public String getKod_pocztowy() {
        return kod_pocztowy;
    }

    public void setKod_pocztowy(String kod_pocztowy) {
        this.kod_pocztowy = kod_pocztowy;
    }

    @Override
    public String toString() {
        return "Adresy{" +
                "id_adresu=" + id_adresu +
                ", miejscowosc='" + miejscowosc + '\'' +
                ", wojewodztwo='" + wojewodztwo + '\'' +
                ", powiat='" + powiat + '\'' +
                ", ulica='" + ulica + '\'' +
                ", nr_domu='" + nr_domu + '\'' +
                ", kod_pocztowy='" + kod_pocztowy + '\'' +
                '}';
    }
}
