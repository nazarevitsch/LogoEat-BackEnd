package com.bida.logoeat.logoeat.service;

import com.bida.logoeat.logoeat.domain.Restaurant;
import com.bida.logoeat.logoeat.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurants(){
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findRestaurantById(id);
    }
}
