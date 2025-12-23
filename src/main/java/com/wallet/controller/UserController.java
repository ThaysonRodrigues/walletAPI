package com.wallet.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.dto.UserDTO;
import com.wallet.entity.User;
import com.wallet.response.Response;
import com.wallet.service.UserService;
import com.wallet.util.Bcrypt;

@RestController
@RequestMapping("/v1/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	public ResponseEntity<Response<UserDTO>> create(@Valid @RequestBody UserDTO dto, BindingResult result) {
		Response<UserDTO> response = new Response<UserDTO>();
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
		User user = service.save(convertDtoToEntity(dto));
		
		response.setData(this.convertEntityToDto(user));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	private User convertDtoToEntity(UserDTO dto) {
		dto.setPassword(Bcrypt.getHash(dto.getPassword()));
	
		return modelMapper.map(dto, User.class);
	}
	
	private UserDTO convertEntityToDto(User u) {
		u.setPassword(null);
		
		return modelMapper.map(u, UserDTO.class);
	}
}
