package com.bida.logoeat.logoeat.repository;

import com.bida.logoeat.logoeat.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Restaurant findRestaurantById(Long id);
}
