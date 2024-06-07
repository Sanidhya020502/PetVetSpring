package com.Major.PetVetSpring.services.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Major.PetVetSpring.dto.SignupRequestDTO;
import com.Major.PetVetSpring.dto.UserDTO;
import com.Major.PetVetSpring.entity.User;
import com.Major.PetVetSpring.enums.UserRole;
import com.Major.PetVetSpring.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserRepository userRepo;
	
	public UserDTO signupClient(SignupRequestDTO signupRequestDTO) {
		User user = new User();
		
		user.setName(signupRequestDTO.getName());
		user.setLastName(signupRequestDTO.getLastName());
		user.setEmail(signupRequestDTO.getEmail());
		user.setPhone(signupRequestDTO.getPhone());
		user.setPassword(new BCryptPasswordEncoder().encode(signupRequestDTO.getPassword()));
		user.setRole(UserRole.CLIENT);
		
		return userRepo.save(user).getDto();
	}
	
	
	public Boolean presentByEmail(String email){
		return userRepo.findFirstByEmail(email) !=null;
	}
	
	public UserDTO signupCompany(SignupRequestDTO signupRequestDTO) {
		User user = new User();
		
		user.setName(signupRequestDTO.getName());
		user.setEmail(signupRequestDTO.getEmail());
		user.setPhone(signupRequestDTO.getPhone());
		user.setAddress(signupRequestDTO.getAddress());
		user.setPassword(new BCryptPasswordEncoder().encode(signupRequestDTO.getPassword()));
		user.setRole(UserRole.COMPANY);
		
		return userRepo.save(user).getDto();
	}
}
