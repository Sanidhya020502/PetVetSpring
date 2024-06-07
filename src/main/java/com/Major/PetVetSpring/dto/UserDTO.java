package com.Major.PetVetSpring.dto;

import com.Major.PetVetSpring.enums.UserRole;

public class UserDTO {

	private Long id;
	
	private String email;
	
	private String password;
	
	private String name;
	
	private String lastName;
	
	private String address;
	
	private String phone;
	
	private UserRole role;

	public UserDTO(String email, String password, String name, String lastName,String address, String phone, UserRole role) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.role = role;
	}

	public UserDTO() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", address="
				+ address + ", lastName=" + lastName + ", phone=" + phone + ", role=" + role + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
