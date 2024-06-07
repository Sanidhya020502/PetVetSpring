package com.Major.PetVetSpring.dto;

import java.util.List;

public class AdDetailsForClientDTO {

	private AdDTO adDTO;
	
	private List<ReviewDTO> reviewDTOList;

	public AdDTO getAdDTO() {
		return adDTO;
	}

	public void setAdDTO(AdDTO adDTO) {
		this.adDTO = adDTO;
	}

	public AdDetailsForClientDTO() {
		super();
	}

	public AdDetailsForClientDTO(AdDTO adDTO, List<ReviewDTO> reviewDTOList) {
		super();
		this.adDTO = adDTO;
		this.reviewDTOList = reviewDTOList;
	}

	public List<ReviewDTO> getReviewDTOList() {
		return reviewDTOList;
	}

	public void setReviewDTOList(List<ReviewDTO> reviewDTOList) {
		this.reviewDTOList = reviewDTOList;
	}

	
	
	
}
