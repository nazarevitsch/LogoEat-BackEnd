package com.bida.logoeat.logoeat.domain;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "Restaurant")
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "address")
    private String address;

    @Column(name = "main_image_link")
    private String mainImageLink;

    @Column(name = "avg_bill")
    private int avgBill;

    @Column(name = "ratting")
    private double ratting;

    public Restaurant() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getMainImageLink() {
        return mainImageLink;
    }

    public void setMainImageLink(String mainImageLink) {
        this.mainImageLink = mainImageLink;
    }

    public int getAvgBill() {
        return avgBill;
    }

    public void setAvgBill(int avgBill) {
        this.avgBill = avgBill;
    }

    public double getRatting() {
        return ratting;
    }

    public void setRating(double ratting) {
        this.ratting = ratting;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", mainImageLink=" + mainImageLink +
                ", avgBill=" + avgBill +
                ", rating=" + ratting +
                '}';
    }
}
