package com.bida.logoeat.logoeat.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "restaurants_images_link")
public class ImagesLinkRestaurant {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private long id;

    @Column(name = "restaurant_id")
    private int restaurantId;

    @Column(name = "image_link")
    private int imageLink;

    public ImagesLinkRestaurant() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getImageLink() {
        return imageLink;
    }

    public void setImageLink(int imageLink) {
        this.imageLink = imageLink;
    }

    @Override
    public String toString() {
        return "ImagesLinkRestaurant{" +
                "id=" + id +
                ", restaurantId=" + restaurantId +
                ", imageLink=" + imageLink +
                '}';
    }
}
