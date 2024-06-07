package com.Major.PetVetSpring.services.company;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Major.PetVetSpring.dto.AdDTO;
import com.Major.PetVetSpring.dto.ReservationDTO;
import com.Major.PetVetSpring.entity.Ad;
import com.Major.PetVetSpring.entity.Reservation;
import com.Major.PetVetSpring.entity.User;
import com.Major.PetVetSpring.enums.ReservationStatus;
import com.Major.PetVetSpring.repository.AdRepository;
import com.Major.PetVetSpring.repository.ReservationRepository;
import com.Major.PetVetSpring.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private ReservationRepository reservationRepo;

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AdRepository adRepo;
	
	public boolean postAd(Long userId, AdDTO adDTO) throws IOException{
		Optional<User> optionalUser = userRepo.findById(userId);
		if(optionalUser.isPresent()) {
			Ad ad  = new Ad();
			ad.setServiceName(adDTO.getServiceName());
			ad.setDescription(adDTO.getDescription());
			ad.setImg(adDTO.getImg().getBytes());
			ad.setPrice(adDTO.getPrice());
			ad.setTimings(adDTO.getTimings());
			ad.setCity(adDTO.getCity());
			ad.setUser(optionalUser.get());
			
			
			adRepo.save(ad);
			return true;
		}
		return false;
	}
	
	@Transactional
	public List<AdDTO> getAllAds(Long userId){
		return adRepo.findAllByUserId(userId).stream().map(Ad::getAdDto).collect(Collectors.toList());
	}
	
	public AdDTO getAdById(Long adId) {
		Optional<Ad> optionalAd = adRepo.findById(adId);
		if(optionalAd.isPresent()) {
			return optionalAd.get().getAdDto();
		}
		return null;
	}
	
	public boolean updateAd(Long adId, AdDTO adDTO) throws IOException{
		Optional<Ad> optionalAd = adRepo.findById(adId);
		if(optionalAd.isPresent()) {
			Ad ad = optionalAd.get();
			
			ad.setServiceName(adDTO.getServiceName());
			ad.setDescription(adDTO.getDescription());
			ad.setPrice(adDTO.getPrice());
			ad.setTimings(adDTO.getTimings());
			ad.setCity(adDTO.getCity());
			
			if(adDTO.getImg()!=null) {
				ad.setImg(adDTO.getImg().getBytes());
			}
			
			adRepo.save(ad);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean deleteAd(Long adId) {
		Optional<Ad> optionalAd = adRepo.findById(adId);
		if(optionalAd.isPresent()) {
			adRepo.delete(optionalAd.get());
			return true;
		}
		return false;
	}
	
	public List<ReservationDTO> getAllAdBookings(Long companyId){
		return reservationRepo.findAllByCompanyId(companyId).stream().map(Reservation::getReservationDTO).collect(Collectors.toList());
	}
	
	public boolean changeBookingStatus(Long bookingId, String status) {
		Optional<Reservation> optionalReservation  = reservationRepo.findById(bookingId);
		if(optionalReservation.isPresent()) {
			Reservation existingReservation = optionalReservation.get();
			if(Objects.equals(status, "Approve")) {
				existingReservation.setReservationStatus(ReservationStatus.APPROVED);
			}else {
				existingReservation.setReservationStatus(ReservationStatus.REJECTED);
			}
			
			reservationRepo.save(existingReservation);
			return true;
		}
		return false;
	}
	
}
