package com.springBootMongoDb.boot.mongo;

import java.io.Serializable;

public class jwtResponse implements Serializable{
private static final long serialVersionUID = 1L;
	
	private String token;
	
	public jwtResponse() {
		super();
	}

	public jwtResponse(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "JwtResponse [token=" + token + "]";
	}
	


}
