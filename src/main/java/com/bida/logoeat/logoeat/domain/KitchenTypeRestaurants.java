package com.bida.logoeat.logoeat.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "kitchen_types_restaurants")
public class KitchenTypeRestaurants {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private long id;

    @Column(name = "restaurant_id")
    private int restaurantId;

    @Column(name = "kitchen_type_id")
    private int kitchenTypeId;

    public KitchenTypeRestaurants() {
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

    public int getKitchenTypeId() {
        return kitchenTypeId;
    }

    public void setKitchenTypeId(int kitchenTypeId) {
        this.kitchenTypeId = kitchenTypeId;
    }

    @Override
    public String toString() {
        return "KitchenTypeRestaurants{" +
                "id=" + id +
                ", restaurantId=" + restaurantId +
                ", kitchenTypeId=" + kitchenTypeId +
                '}';
    }
}
