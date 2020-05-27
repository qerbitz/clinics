package com.clinics.clinics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Badania")
public class Research {

    @Id
    @Column(name = "id_badania")
    private int id_research;

    @Column (name = "nazwa")
    private String name;

    public Research(int id_research, String name) {
        this.id_research = id_research;
        this.name = name;
    }

    public Research(){

    }

    public int getId_research() {
        return id_research;
    }

    public void setId_research(int id_research) {
        this.id_research = id_research;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Research{" +
                "id_research=" + id_research +
                ", name='" + name + '\'' +
                '}';
    }
}
