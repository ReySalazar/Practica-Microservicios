package com.moto.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moto.service.entity.Bike;
import com.moto.service.repository.BikeRepository;

@Service
public class BikeService {
	
	@Autowired
	BikeRepository bikeRepository;
	
	
	public List<Bike> getAll() {
		return bikeRepository.findAll();
	}
	
	public Bike getBikeById(int id) {
		return bikeRepository.findById(id).orElse(null);		
	}
	
	public Bike saveBike(Bike bike) {
		Bike newBike = bikeRepository.save(bike);
		return newBike;
	}
	
	public List<Bike> byUserId(int userId){
		return bikeRepository.findByUserId(userId);
	}
}
