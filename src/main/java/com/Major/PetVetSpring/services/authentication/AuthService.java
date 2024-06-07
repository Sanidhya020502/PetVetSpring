package com.Major.PetVetSpring.services.authentication;

import com.Major.PetVetSpring.dto.SignupRequestDTO;
import com.Major.PetVetSpring.dto.UserDTO;

public interface AuthService {

	UserDTO signupClient(SignupRequestDTO signupRequestDTO);
	
	UserDTO signupCompany(SignupRequestDTO signupRequestDTO);
	
	Boolean presentByEmail(String email);
}
