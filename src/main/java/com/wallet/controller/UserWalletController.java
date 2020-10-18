package com.wallet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.dto.UserWalletDTO;
import com.wallet.entity.User;
import com.wallet.entity.UserWallet;
import com.wallet.entity.Wallet;
import com.wallet.response.Response;
import com.wallet.service.UserWalletService;

@RestController
@RequestMapping(path = "user-wallet")
public class UserWalletController {
	
	@Autowired
	private UserWalletService service;
	
	@PostMapping
	public ResponseEntity<Response<UserWalletDTO>> create(@Valid @RequestBody UserWalletDTO dto, BindingResult result) {
		Response<UserWalletDTO> response = new Response<UserWalletDTO>();
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(r -> response.getErrors().add(r.getDefaultMessage()));
			
			return ResponseEntity.badRequest().body(response);
		}
		
		UserWallet uw = service.save(this.convertDtoToEntity(dto));
		
		response.setData(this.convertEntityToDto(uw));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
		
	}
	
	private UserWallet convertDtoToEntity(UserWalletDTO dto) {
		UserWallet uw = new UserWallet();
		
		User user = new User(dto.getUsers());
		Wallet wallet = new Wallet(dto.getWallet());
		
		uw.setUsers(user);
		uw.setWallet(wallet);
		
		return uw;
	}
	
	private UserWalletDTO convertEntityToDto(UserWallet entity) {
		UserWalletDTO dto = new UserWalletDTO();
		
		User user = new User(entity.getUsers().getId());
		Wallet wallet = new Wallet(entity.getWallet().getId());
		
		dto.setId(entity.getId());
		dto.setUsers(user.getId());
		dto.setWallet(wallet.getId());
		
		return dto;
	}
}
