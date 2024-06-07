package com.Major.PetVetSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.Major.PetVetSpring.entity.Ad;

@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {
	
//Now Spring JPA will create the implementation of above methods automatically as we've following the property based nomenclature.
	List<Ad> findAllByUserId(Long userId);
	
	List<Ad> findAllByCityContaining(String city);
	
	
	

}
