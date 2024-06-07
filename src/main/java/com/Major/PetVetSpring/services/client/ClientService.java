package com.Major.PetVetSpring.services.client;

import java.util.List;

import com.Major.PetVetSpring.dto.AdDTO;
import com.Major.PetVetSpring.dto.AdDetailsForClientDTO;
import com.Major.PetVetSpring.dto.ReservationDTO;
import com.Major.PetVetSpring.dto.ReviewDTO;

public interface ClientService {
	
	List<AdDTO> getAllAds();
	List<AdDTO> searchAdByCity(String city);
	boolean bookService(ReservationDTO reservationDTO);
	AdDetailsForClientDTO getAdDetailsById(Long adId);
	List<ReservationDTO> getAllBookingsByUserId(Long userId);
	boolean giveReview(ReviewDTO reviewDTO);

}
