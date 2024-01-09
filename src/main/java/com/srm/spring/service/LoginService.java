package com.srm.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.srm.spring.dao.LoginDAO;
import com.srm.spring.dto.CustomerCredientialsDTO;
import com.srm.spring.model.CustomerCredientials;

@Component
public class LoginService {
	
	@Autowired
	LoginDAO loginDAO;
	
	@Transactional
	public CustomerCredientialsDTO doLogin(CustomerCredientialsDTO dtoObject) throws Exception{
		CustomerCredientials model= new CustomerCredientials();
		model.setUsername(dtoObject.getUsername());
		model.setPassword(dtoObject.getPassword());
		return loginDAO.doLogin(model);
	}
	
}
