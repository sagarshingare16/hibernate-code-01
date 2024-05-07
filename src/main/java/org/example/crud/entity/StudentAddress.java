package org.example.crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class StudentAddress {
    @Column(name = "house_number")
    private int houseNumber;
    @Column(name = "locality")
    private String locality;
    @Column(name = "city_name")
    private String cityName;

    public StudentAddress() {
        System.out.println("StudentAddress constructor called..");
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getArea() {
        return locality;
    }

    public void setArea(String area) {
        this.locality = area;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "StudentAddress{" +
                "houseNumber=" + houseNumber +
                ", area='" + locality + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
