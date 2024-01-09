package com.srm.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.srm.spring.dto.APISuccessPayload;
import com.srm.spring.dto.CustomerCredientialsDTO;
import com.srm.spring.service.LoginService;

@RestController
@RequestMapping("/rest/login")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/doLogin", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity doLogin(@RequestBody CustomerCredientialsDTO dtoObject){
		String status="";
		CustomerCredientialsDTO resObj = null;
		try{
			resObj=loginService.doLogin(dtoObject);
			APISuccessPayload apiPayload = new APISuccessPayload();
			apiPayload.setStatusCode(HttpStatus.ACCEPTED);
			apiPayload.setBody(resObj);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiPayload);
			
		}catch(Exception ex){
			APISuccessPayload apiPayload = new APISuccessPayload();
			apiPayload.setStatusCode(HttpStatus.BAD_REQUEST);
			apiPayload.setBody(resObj);
			apiPayload.setSucess(true);
			apiPayload.setCause(ex.getLocalizedMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiPayload);
		}
	 	 
	}

}
