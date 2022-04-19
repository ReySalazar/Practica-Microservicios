package com.usuario.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.usuario.service.entity.User;
import com.usuario.service.feingclients.CarFeingClient;
import com.usuario.service.model.Bike;
import com.usuario.service.model.Car;
import com.usuario.service.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CarFeingClient carFeingClient;
	
	public List<Car> getCars(int userId) {
		List<Car> cars = restTemplate.getForObject("http://localhost:8002/car/user/" + userId, List.class);
		return cars;
	}
	
	public Car saveCar(int userId, Car car) {
		car.setUserId(userId);
		Car newCar = carFeingClient.save(car);
		return newCar;
	}
	
	public List<Bike> getBikes(int userId) {
		List<Bike> bikes = restTemplate.getForObject("http://localhost:8003/bike/user/" + userId, List.class);
		return bikes;
	}
	
	public List<User> getAll() {
		return userRepository.findAll();
	}
	
	public User getUserById(int id) {
		return userRepository.findById(id).orElse(null);		
	}
	
	public User saveUser(User user) {
		User newUser = userRepository.save(user);
		return newUser;
	}

}
