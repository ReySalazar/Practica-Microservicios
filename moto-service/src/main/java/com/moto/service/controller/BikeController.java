package com.moto.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moto.service.entity.Bike;
import com.moto.service.service.BikeService;

@RestController
@RequestMapping("/bike")
public class BikeController {
	
	@Autowired
	BikeService bikeService;
	
	@GetMapping
	public ResponseEntity<List<Bike>> getCarList(){
		
		List<Bike> bikes = bikeService.getAll();
		if (bikes.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(bikes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Bike> getBike(@PathVariable("id") int id){
		Bike bike = bikeService.getBikeById(id);
		if (bike == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(bike);
	}
	
	@PostMapping
	public ResponseEntity<Bike> saveBike(@RequestBody Bike bike) {
		Bike newBike = bikeService.saveBike(bike);
		return ResponseEntity.ok(newBike);
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Bike>> getBikeListByUserId (@PathVariable int userId) {
		List<Bike> bikes = bikeService.byUserId(userId);
		if (bikes.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(bikes);
	}
}
