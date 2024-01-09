package com.srm.spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.srm.spring.dto.EmployeeDetailsDTO;
import com.srm.spring.service.EmployeeDetailsService;

@RestController
@RequestMapping(value = "/rest/empdtl")
public class EmployeeDetailsController {
	
	@Autowired
	private EmployeeDetailsService employeeDetailsService;
	
	@RequestMapping(value = "/saveEmployeeDetails", method = RequestMethod.POST)
	public @ResponseBody EmployeeDetailsDTO saveEmployeeDetails(@RequestBody EmployeeDetailsDTO dto){
		EmployeeDetailsDTO retDto=null;
		try{
			retDto=employeeDetailsService.saveEmployeeDetails(dto);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return retDto;
	}
	
	@RequestMapping(value = "/getAllEmployeeDetails", method = RequestMethod.GET)
	public @ResponseBody List<EmployeeDetailsDTO> getAllEmployeeDetails(){
		List<EmployeeDetailsDTO> dtoList=null;
		try{
			dtoList=employeeDetailsService.getAllEmployeeDetails();
		}catch(Exception ex){
			
		}
		return dtoList;		
	}

}
