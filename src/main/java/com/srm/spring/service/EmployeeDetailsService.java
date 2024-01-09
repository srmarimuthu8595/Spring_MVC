package com.srm.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.srm.spring.dao.EmployeeDetailsDAO;
import com.srm.spring.dto.EmployeeDetailsDTO;
import com.srm.spring.model.EmployeeDetails;

@Component
public class EmployeeDetailsService {
	
	@Autowired
	EmployeeDetailsDAO employeeDetailsDAO;
	
	@Transactional
	public EmployeeDetailsDTO saveEmployeeDetails(EmployeeDetailsDTO dto) throws Exception{
		EmployeeDetails empModel = new EmployeeDetails();
		
		empModel.setEmpid(dto.getEmpid());
		empModel.setEmployeename(dto.getEmployeename());
		empModel.setDepartment(dto.getDepartment());
		empModel.setBranchname(dto.getBranchname());
		empModel.setSalary(dto.getSalary());
		empModel.setDob(dto.getDob());
		empModel =employeeDetailsDAO.saveEmployeeDetails(empModel);
		dto.setEmpid(empModel.getEmpid());
		return dto;
	}
	
	@Transactional
	public List<EmployeeDetailsDTO> getAllEmployeeDetails() throws Exception{
		List<EmployeeDetailsDTO> empDtoList= new ArrayList<EmployeeDetailsDTO>();
		List<EmployeeDetails> employeeList=employeeDetailsDAO.getAllEmployeeDetails();
		for(EmployeeDetails model:employeeList){
			EmployeeDetailsDTO dto = new EmployeeDetailsDTO();
			dto.setEmpid(model.getEmpid());
			dto.setEmployeename(model.getEmployeename());
			dto.setDepartment(model.getDepartment());
			dto.setBranchname(model.getBranchname());
		    dto.setSalary(model.getSalary());
		    dto.setDob(model.getDob());
		    empDtoList.add(dto);
		}
		return empDtoList;		
	}

}
