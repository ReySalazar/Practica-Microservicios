package com.moto.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moto.service.entity.Bike;

public interface BikeRepository extends JpaRepository<Bike, Integer>{
	List<Bike> findByUserId(int userId);
}
