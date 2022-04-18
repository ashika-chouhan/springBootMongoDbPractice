package com.springBootMongoDb.boot.mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springBootMongoDb.boot.mongo.jwtRequest;
import com.springBootMongoDb.boot.mongo.jwtResponse;

import config.JwtUtil;
import service.CustomUserDetailsService;

@RestController
public class jwtController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private CustomUserDetailsService customUserDetailService;

	@PostMapping("/token")
	public ResponseEntity<jwtResponse> generateToken(@RequestBody jwtRequest jwtRequest) throws Exception {
		System.out.println("Username :" + jwtRequest.getUsername() + ", Password :" + jwtRequest.getPassword());

		authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());

		final UserDetails userDetails = customUserDetailService.loadUserByUsername(jwtRequest.getUsername());

		final String token = jwtUtil.generateToken(userDetails);

		return ResponseEntity.ok(new jwtResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}


}
