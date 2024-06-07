package com.Major.PetVetSpring.services.client;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Major.PetVetSpring.dto.AdDTO;
import com.Major.PetVetSpring.dto.AdDetailsForClientDTO;
import com.Major.PetVetSpring.dto.ReservationDTO;
import com.Major.PetVetSpring.dto.ReviewDTO;
import com.Major.PetVetSpring.entity.Ad;
import com.Major.PetVetSpring.entity.Reservation;
import com.Major.PetVetSpring.entity.Review;
import com.Major.PetVetSpring.entity.User;
import com.Major.PetVetSpring.enums.ReservationStatus;
import com.Major.PetVetSpring.enums.ReviewStatus;
import com.Major.PetVetSpring.repository.AdRepository;
import com.Major.PetVetSpring.repository.ReservationRepository;
import com.Major.PetVetSpring.repository.ReviewRepository;
import com.Major.PetVetSpring.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AdRepository adRepo;
	
	@Autowired
	private ReservationRepository reservationRepo;
	
	@Autowired
	private ReviewRepository reviewRepo;
	
	public List<AdDTO> getAllAds(){
		return adRepo.findAll().stream().map(Ad::getAdDto).collect(Collectors.toList());
	}
	
	public List<AdDTO> searchAdByCity(String city){
		return adRepo.findAllByCityContaining(city).stream().map(Ad::getAdDto).collect(Collectors.toList());
	}
	
	public boolean bookService(ReservationDTO reservationDTO) {
		Optional<Ad> optionalAd = adRepo.findById(reservationDTO.getAdId());
		Optional<User> optionalUser = userRepo.findById(reservationDTO.getUserId());
		
		if(optionalAd.isPresent() && optionalUser.isPresent()) {
			Reservation reservation = new Reservation();
			reservation.setBookDate(reservationDTO.getBookDate());
			reservation.setReservationStatus(ReservationStatus.PENDING);
			reservation.setUser(optionalUser.get());
			
			reservation.setAd(optionalAd.get());
			reservation.setCompany(optionalAd.get().getUser());
			reservation.setReviewStatus(ReviewStatus.FALSE);
			
			reservationRepo.save(reservation);
			return true;
			
		}
		return false;
	}
	
	public AdDetailsForClientDTO getAdDetailsById(Long adId) {
		Optional<Ad> optionalAd = adRepo.findById(adId);
		AdDetailsForClientDTO adDetailsForClientDTO = new AdDetailsForClientDTO();
		if(optionalAd.isPresent()) {
			adDetailsForClientDTO.setAdDTO(optionalAd.get().getAdDto());
			
			List<Review> reviewList = reviewRepo.findAllByAdId(adId);
			adDetailsForClientDTO.setReviewDTOList(reviewList.stream().map(Review::getDto).collect(Collectors.toList()));
			
		}
		return adDetailsForClientDTO;
	}
	
	public List<ReservationDTO> getAllBookingsByUserId(Long userId){
		return reservationRepo.findAllByUserId(userId).stream().map(Reservation::getReservationDTO).collect(Collectors.toList());
	}
	
	@Transactional
	public boolean giveReview(ReviewDTO reviewDTO) {
		if (reviewDTO.getUserId() == null || reviewDTO.getBookId() == null) {
	        // Handle null IDs appropriately
	        return false;
	    }
		Optional<User> optionalUser = userRepo.findById(reviewDTO.getUserId());
		Optional<Reservation> optionalBooking = reservationRepo.findById(reviewDTO.getBookId());
		
		if(optionalUser.isPresent() && optionalBooking.isPresent()) {
			Review review = new Review();
			review.setReviewDate(new Date());
			review.setReview(reviewDTO.getReview());
			review.setRating(reviewDTO.getRating());
			
			review.setUser(optionalUser.get());
			review.setAd(optionalBooking.get().getAd());
			
			reviewRepo.save(review);
			
			Reservation booking = optionalBooking.get();
			booking.setReviewStatus(ReviewStatus.TRUE);
			
			reservationRepo.save(booking);
			
			return true;
		}
		return false;
	}
}
