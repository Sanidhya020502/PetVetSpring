package com.Major.PetVetSpring.dto;

import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

public class AdDTO {

	private Long id;
	
	private String serviceName;
	
	private String description;
	
	private Double price;
	
	private String timings;
	
	private String city;
	
	
	private MultipartFile img;
	
	private byte[] returnedImg;
	
	private Long userId;
	
	private String companyName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	


	public String getTimings() {
		return timings;
	}

	public void setTimings(String timings) {
		this.timings = timings;
	}

	public byte[] getReturnedImg() {
		return returnedImg;
	}

	public void setReturnedImg(byte[] returnedImg) {
		this.returnedImg = returnedImg;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public MultipartFile getImg() {
		return img;
	}

	public void setImg(MultipartFile img) {
		this.img = img;
	}

	public AdDTO() {
		super();
	}

	public AdDTO(String serviceName, String description, Double price,String timings,String city, MultipartFile img, byte[] returnedImg,
			Long userId, String companyName) {
		super();
		this.serviceName = serviceName;
		this.description = description;
		this.price = price;
		this.timings = timings;
		this.city = city;
		this.img = img;
		this.returnedImg = returnedImg;
		this.userId = userId;
		this.companyName = companyName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "AdDTO [id=" + id + ", serviceName=" + serviceName + ", description=" + description + ", price=" + price
				+ ", timings=" + timings + ", city=" + city + ",  img=" + img + ", returnedImg="
				+ Arrays.toString(returnedImg) + ", userId=" + userId + ", companyName=" + companyName + "]";
	}

	

	

	
	
	

	

	
	
	
}
