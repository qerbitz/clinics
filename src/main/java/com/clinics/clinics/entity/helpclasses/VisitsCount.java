package com.clinics.clinics.entity.helpclasses;

public class VisitsCount {

    private String place;
    private String street;
    private String count;

    public VisitsCount(String place, String street, String count) {
        this.place = place;
        this.street = street;
        this.count = count;
    }

    public VisitsCount() {
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "VisitsCount{" +
                "place='" + place + '\'' +
                ", street='" + street + '\'' +
                ", count='" + count + '\'' +
                '}';
    }
}
