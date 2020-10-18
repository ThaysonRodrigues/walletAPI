package com.wallet.security;

import com.wallet.entity.User;

public class JwtUserFactory {
	
	public JwtUserFactory() {}
	
	public static JwtUser create(User user) {
		return new JwtUser(user.getId(), user.getEmail(), user.getPassword());
	}
	
//	private static List<GrantedAuthority> createGrantedAuthorities(RoleEnum role) {
//		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//		authorities.add(new SimpleGrantedAuthority(role.toString()));
//		return authorities;
//	}
	
}
