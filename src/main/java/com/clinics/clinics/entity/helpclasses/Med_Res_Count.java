package com.clinics.clinics.entity.helpclasses;

public class Med_Res_Count {

    private String place;
    private String street;
    private String count_med;
    private String count_res;

    public Med_Res_Count(String place, String street, String count_med, String count_res) {
        this.place = place;
        this.street = street;
        this.count_med = count_med;
        this.count_res = count_res;
    }

    public Med_Res_Count() {
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

    public String getCount_med() {
        return count_med;
    }

    public void setCount_med(String count_med) {
        this.count_med = count_med;
    }

    public String getCount_res() {
        return count_res;
    }

    public void setCount_res(String count_res) {
        this.count_res = count_res;
    }

    @Override
    public String toString() {
        return "Med_Res_Count{" +
                "place='" + place + '\'' +
                ", street='" + street + '\'' +
                ", count_med='" + count_med + '\'' +
                ", count_res='" + count_res + '\'' +
                '}';
    }
}
