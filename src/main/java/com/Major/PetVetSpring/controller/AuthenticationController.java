package com.Major.PetVetSpring.controller;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.Major.PetVetSpring.dto.AuthenticationRequest;
import com.Major.PetVetSpring.dto.AuthenticationResponse;
import com.Major.PetVetSpring.dto.SignupRequestDTO;
import com.Major.PetVetSpring.dto.UserDTO;
import com.Major.PetVetSpring.entity.User;
import com.Major.PetVetSpring.repository.UserRepository;
import com.Major.PetVetSpring.services.authentication.AuthService;
import com.Major.PetVetSpring.services.jwt.UserDetailsServiceImpl;
import com.Major.PetVetSpring.util.JwtUtil;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class AuthenticationController {

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepo;
	
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	
	@PostMapping("/client/sign-up")
	public ResponseEntity<?> signupClient(@RequestBody SignupRequestDTO signupRequestDTO ){
		if(authService.presentByEmail(signupRequestDTO.getEmail())) {
			return new ResponseEntity<>("Client already exists with this Email",HttpStatus.NOT_ACCEPTABLE );
		}
		
		UserDTO createdUser1 = authService.signupClient(signupRequestDTO);
		return new ResponseEntity<>(createdUser1,HttpStatus.OK);
	}
	
	@PostMapping("/company/sign-up")
	public ResponseEntity<?> signupCompany(@RequestBody SignupRequestDTO signupRequestDTO ){
		if(authService.presentByEmail(signupRequestDTO.getEmail())) {
			return new ResponseEntity<>("Company already exists with this Email",HttpStatus.NOT_ACCEPTABLE );
		}
		
		UserDTO createdUser = authService.signupCompany(signupRequestDTO);
		return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
	}
	
	
	@PostMapping("/authenticate")
	public void createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest,HttpServletResponse response) throws BadCredentialsException, DisabledException, UsernameNotFoundException,IOException, java.io.IOException, JSONException {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));
		} catch(BadCredentialsException e) {
			throw new BadCredentialsException("Incorrect username/password");
		} catch(DisabledException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND,"User is not created. Register User first.");
			//return null;
		}
		final UserDetails userDetails  = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
		final String jwt = jwtUtil.generateToken(userDetails.getUsername());
		User user = userRepo.findFirstByEmail(authenticationRequest.getEmail());
		
		response.getWriter().write(new JSONObject()
				.put("userId", user.getId())
				.put("role",user.getRole())
				.toString()
				); 

		response.addHeader("Access-Control-Expose-Headers", "Authorization");
		response.addHeader("Access-Control-Allow-Headers", "Authorization," + 
		" X-PINGOTHER, Origin, X-Requested-With, Consent-Type, Accept, X-Custom-header");
		
		response.addHeader(HEADER_STRING, TOKEN_PREFIX+jwt);
		//return new AuthenticationResponse(jwt);
		
	}
	
}
