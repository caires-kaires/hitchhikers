package com.caronas.hitchhikers.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.caronas.hitchhikers.model.converter.PasswordConverter;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Nome dever ser informado")
	private String name;
	
	@Email(message = "Email invalido")
	@NotBlank(message = "Email dever ser informado")
	private String email;
	
	@Convert(converter = PasswordConverter.class)
	@NotBlank(message = "Password dever ser informado")
	private String password;

	@OneToMany(mappedBy = "owner", cascade = { CascadeType.ALL })
	private List<Car> cars = new ArrayList<Car>();
	
	public static User savedUser(User user) {
		User u = new User();
		u.id = user.id;
		u.name = user.name;
		u.email = user.email;
		u.cars = user.cars;
		return u;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
}
