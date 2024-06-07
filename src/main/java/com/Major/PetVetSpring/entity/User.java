package com.Major.PetVetSpring.entity;


import com.Major.PetVetSpring.dto.UserDTO;
import com.Major.PetVetSpring.enums.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String email;
	
	private String password;
	
	private String name;
	
	private String address;
	
	private String lastName;
	
	private String phone;
	
	private UserRole role;
	
	public UserDTO getDto() {
		UserDTO userDto = new UserDTO();
		userDto.setId(id);
		userDto.setName(name);
		userDto.setLastName(lastName);
		userDto.setAddress(address);
		userDto.setEmail(email);
		userDto.setPhone(phone);
		userDto.setRole(role);
		
		return userDto;
	}
	

	

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", address="
				+ address + ", lastName=" + lastName + ", phone=" + phone + ", role=" + role + "]";
	}




	public User() {
		super();
	}

	public User(String email, String password, String name, String lastName, String phone,String address, UserRole role) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
		this.role = role;
	}

	public Long getId() {
		return id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}




	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
	
	
	

}
