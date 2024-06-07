package com.Major.PetVetSpring.dto;

import java.util.Date;

public class ReviewDTO {

	private Long id;
	
	private Date reviewDate;
	
	private String review;
	
	private Long rating;
	
	private Long userId;
	
	private Long adId;
	
	private String clientName;
	
	private String serviceName;
	
	private Long bookId;

	public ReviewDTO() {
		super();
	}

	public ReviewDTO(Long id, Date reviewDate, String review, Long rating, Long userId, Long adId, String clientName,
			String serviceName, Long bookId) {
		super();
		this.id = id;
		this.reviewDate = reviewDate;
		this.review = review;
		this.rating = rating;
		this.userId = userId;
		this.adId = adId;
		this.clientName = clientName;
		this.serviceName = serviceName;
		this.bookId = bookId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getAdId() {
		return adId;
	}

	public void setAdId(Long adId) {
		this.adId = adId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	@Override
	public String toString() {
		return "ReviewDTO [id=" + id + ", reviewDate=" + reviewDate + ", review=" + review + ", rating=" + rating
				+ ", userId=" + userId + ", adId=" + adId + ", clientName=" + clientName + ", serviceName="
				+ serviceName + ", bookId=" + bookId + "]";
	}
	
	
}
