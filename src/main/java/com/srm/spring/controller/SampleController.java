package com.srm.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/sample")
public class SampleController {
	
	
	@RequestMapping(value = "displayData")
	public String displayData(){
		System.out.println("displayData =======================>");
		return "displayData ========================>";
	}

}
