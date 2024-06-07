package com.Major.PetVetSpring.entity;

import java.util.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.Major.PetVetSpring.dto.ReviewDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date reviewDate;
	
	private String review;
	
	private Long rating;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name="user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name="ad_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Ad ad;
	
	public ReviewDTO getDto() {
		ReviewDTO reviewDTO = new ReviewDTO();
		reviewDTO.setId(id);
		reviewDTO.setReview(review);
		reviewDTO.setRating(rating);
		reviewDTO.setReviewDate(reviewDate);
		reviewDTO.setUserId(user.getId());
		reviewDTO.setClientName(user.getName());
		reviewDTO.setAdId(ad.getId());
		reviewDTO.setServiceName(ad.getServiceName());
		
		return reviewDTO;
		
		
	}

	public Review(Date reviewDate, String review, Long rating, User user, Ad ad) {
		super();
		this.reviewDate = reviewDate;
		this.review = review;
		this.rating = rating;
		this.user = user;
		this.ad = ad;
	}

	public Review() {
		super();
	}

	public Long getId() {
		return id;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Ad getAd() {
		return ad;
	}

	public void setAd(Ad ad) {
		this.ad = ad;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", reviewDate=" + reviewDate + ", review=" + review + ", rating=" + rating
				+ ", user=" + user + ", ad=" + ad + "]";
	}
	
	
	
	
	
}
