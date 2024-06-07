package com.Major.PetVetSpring.entity;

import java.util.Arrays;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.Major.PetVetSpring.dto.AdDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ads")
public class Ad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String serviceName;
	
	private String description;
	
	private Double price;
	
	private String timings;
	
	private String city;
	
	@Lob
	@Column(columnDefinition = "longblob")
	private byte[] img;
	
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "user_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;
	
	public AdDTO getAdDto() {
		AdDTO adDTO = new AdDTO();
		adDTO.setId(id);
		adDTO.setServiceName(serviceName);
		adDTO.setDescription(description);
		adDTO.setPrice(price);
		adDTO.setTimings(timings);
		adDTO.setCity(city);
		adDTO.setCompanyName(user.getName());
		adDTO.setReturnedImg(img);
		
		return adDTO;
		
		
	}


	public Ad(String serviceName, String description, Double price,String timings,String city,  byte[] img, User user) {
		super();
		this.serviceName = serviceName;
		this.description = description;
		this.price = price;
		this.timings = timings;
		this.city = city;
		this.img = img;
		this.user = user;
	}


	public Ad() {
		super();
	}


	public Long getId() {
		return id;
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
	
	


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public byte[] getImg() {
		return img;
	}


	public void setImg(byte[] img) {
		this.img = img;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Ad [id=" + id + ", serviceName=" + serviceName + ", description=" + description + ", price=" + price
				+ ", timings=" + timings + ", city=" + city + ", img=" + Arrays.toString(img) + ", user=" + user + "]";
	}


	
	
	
	
	
	
	
}
