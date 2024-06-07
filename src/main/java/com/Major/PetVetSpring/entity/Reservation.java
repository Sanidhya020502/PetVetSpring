package com.Major.PetVetSpring.entity;

import java.util.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.Major.PetVetSpring.dto.ReservationDTO;
import com.Major.PetVetSpring.enums.ReservationStatus;
import com.Major.PetVetSpring.enums.ReviewStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private ReservationStatus reservationStatus;
	
	private ReviewStatus reviewStatus;
	
	private Date bookDate;
	
	private String serviceName;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name="user_id", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name="company_id", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User company;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name="ad_id", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Ad ad;
	
	
	public ReservationDTO getReservationDTO() {
		ReservationDTO dto = new ReservationDTO();
		dto.setId(id);
		dto.setServiceName(ad.getServiceName());
		dto.setBookDate(bookDate);
		dto.setReservationStatus(reservationStatus);
		dto.setReviewStatus(reviewStatus);
		dto.setAdId(ad.getId());
		dto.setCompanyId(company.getId());
		dto.setUserName(user.getName());
		return dto;
		
	}

	public Long getId() {
		return id;
	}

	public ReservationStatus getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(ReservationStatus reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public ReviewStatus getReviewStatus() {
		return reviewStatus;
	}

	public void setReviewStatus(ReviewStatus reviewStatus) {
		this.reviewStatus = reviewStatus;
	}

	public Date getBookDate() {
		return bookDate;
	}

	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}
	
	public String getServiceName() {
		return serviceName;
	}
	
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getCompany() {
		return company;
	}

	public void setCompany(User company) {
		this.company = company;
	}

	public Ad getAd() {
		return ad;
	}

	public void setAd(Ad ad) {
		this.ad = ad;
	}





	public Reservation(ReservationStatus reservationStatus, ReviewStatus reviewStatus, Date bookDate,
			String serviceName, User user, User company, Ad ad) {
		super();
		this.reservationStatus = reservationStatus;
		this.reviewStatus = reviewStatus;
		this.bookDate = bookDate;
		this.serviceName = serviceName;
		this.user = user;
		this.company = company;
		this.ad = ad;
	}

	public Reservation() {
		super();
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", reservationStatus=" + reservationStatus + ", reviewStatus=" + reviewStatus
				+ ", bookDate=" + bookDate + ", serviceName=" + serviceName + ", user=" + user + ", company=" + company
				+ ", ad=" + ad + "]";
	}

	
	
	
	
	
	
	
	
}
