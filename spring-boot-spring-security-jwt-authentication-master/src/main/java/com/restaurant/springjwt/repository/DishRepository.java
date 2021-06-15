package com.restaurant.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.springjwt.models.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish,Long> {

}
