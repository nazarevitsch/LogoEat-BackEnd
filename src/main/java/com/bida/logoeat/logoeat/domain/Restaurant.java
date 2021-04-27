package com.bida.logoeat.logoeat.domain;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
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

    @Column(name = "main_image_link_id")
    private int mainImageLinkId;

    @Column(name = "avg_bill")
    private int avgBill;

    @Column(name = "rating")
    private double rating;


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

    public int getMainImageLinkId() {
        return mainImageLinkId;
    }

    public void setMainImageLinkId(int mainImageLinkId) {
        this.mainImageLinkId = mainImageLinkId;
    }

    public int getAvgBill() {
        return avgBill;
    }

    public void setAvgBill(int avgBill) {
        this.avgBill = avgBill;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", mainImageLinkId=" + mainImageLinkId +
                ", avgBill=" + avgBill +
                ", rating=" + rating +
                '}';
    }
}
