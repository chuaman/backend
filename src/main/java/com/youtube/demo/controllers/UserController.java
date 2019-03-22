package com.youtube.demo.controllers;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.youtube.demo.model.User;
import com.youtube.demo.service.UserService;
import com.youtube.demo.util.RestResponse;

@RestController
public class UserController {

	@Autowired
	protected UserService userService;
	
	protected ObjectMapper mapper;
	
	
	@RequestMapping(value ="/saveOrUpdate", method = RequestMethod.POST)
	public RestResponse saveOrUpdate(@RequestBody String Userjson) throws JsonParseException, JsonMappingException, IOException {

	this.mapper = new ObjectMapper();	
		
	 User user = this.mapper.readValue(Userjson, User.class);
	 
	 if(!this.validate(user)) {
		 return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),"Los campos obligatorios no estan diligenciados");
	 }
	 this.userService.save(user);
		return new RestResponse(HttpStatus.OK.value(),"Operacion Existosa");
		
		
	}
	
	@RequestMapping(value ="/getUsers", method = RequestMethod.GET)
	public List<User> getUsers(){
		return this.userService.finAll();
		
	}
	
	
	
	private boolean validate(User user) {
		boolean invalid = true;
		
//		if(user.getFirstName()== null) {
		if(StringUtils.trimToNull(user.getFirstName())== null) {
			invalid = false;
		}
		
//		if(user.getFirstSurname()== null) {
		if(StringUtils.trimToNull(user.getFirstSurname())== null) {
			invalid = false;
		}
		
		if(StringUtils.trimToNull(user.getAddress())== null) {
			invalid = false;
		}
		
		return invalid;
		
	}
	
}
