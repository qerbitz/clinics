package com.clinics.clinics.entity;

import javax.persistence.*;

@Entity
@Table(name = "Wizyty_leki_badania")
public class Vis_Med_Res {

    @Id
    @Column(name = "ajdi")
    private int ajdi;

    @ManyToOne
    @JoinColumn(name ="id_wizyty")
    private Visits id_visit;

    @ManyToOne
    @JoinColumn(name ="id_badania")
    private Research id_research;

    @ManyToOne
    @JoinColumn(name ="id_leku")
    private Medicines id_medicine;

    public Vis_Med_Res(int ajdi, Visits id_visit, Research id_research, Medicines id_medicine) {
        this.ajdi = ajdi;
        this.id_visit = id_visit;
        this.id_research = id_research;
        this.id_medicine = id_medicine;
    }

    public Vis_Med_Res(){

    }

    public int getAjdi() {
        return ajdi;
    }

    public void setAjdi(int ajdi) {
        this.ajdi = ajdi;
    }

    public Visits getId_visit() {
        return id_visit;
    }

    public void setId_visit(Visits id_visit) {
        this.id_visit = id_visit;
    }

    public Research getId_research() {
        return id_research;
    }

    public void setId_research(Research id_research) {
        this.id_research = id_research;
    }

    public Medicines getId_medicine() {
        return id_medicine;
    }

    public void setId_medicine(Medicines id_medicine) {
        this.id_medicine = id_medicine;
    }

    @Override
    public String toString() {
        return "Vis_Med_Res{" +
                "ajdi=" + ajdi +
                ", id_visit=" + id_visit +
                ", id_research=" + id_research.getName() +
                ", id_medicine=" + id_medicine +
                '}';
    }


}
