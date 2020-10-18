package com.wallet.security.dto;

public class TokenDTO {

	private String token;

	public TokenDTO() {}
	
	public TokenDTO(String token) {
		this.token = token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public String getToken() {
		return token;
	}
}
