package com.caronas.hitchhikers.model.dto;

import java.util.List;

import com.caronas.hitchhikers.model.Car;

public class UserDto {

	private Long id;
	private String name;
	private String email;
	private List<Car> cars;
	

	public UserDto(Long id, String name, String email, List<Car> cars) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.cars = cars;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

}
