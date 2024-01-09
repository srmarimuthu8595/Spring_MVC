package com.srm.spring.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;

public class CustomerDetailsDTO {

	private Integer custid;

	private String custname;

	private String fathername;
	
	private Date dob;
	
	private String occupation;

	private String panno;
	
	private String companyname;
	
	private double salary;
	
	private String status;
	
	private List<CustomerAddressDetailsDTO> custAddressDtlsDTOList;
	
	private CustomerCredientialsDTO custCredientialsDTO;

	public Integer getCustid() {
		return custid;
	}

	public void setCustid(Integer custid) {
		this.custid = custid;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getPanno() {
		return panno;
	}

	public void setPanno(String panno) {
		this.panno = panno;
	}
		
	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public List<CustomerAddressDetailsDTO> getCustAddressDtlsDTOList() {
		return custAddressDtlsDTOList;
	}

	public void setCustAddressDtlsDTOList(List<CustomerAddressDetailsDTO> custAddressDtlsDTOList) {
		this.custAddressDtlsDTOList = custAddressDtlsDTOList;
	}

	public CustomerCredientialsDTO getCustCredientialsDTO() {
		return custCredientialsDTO;
	}

	public void setCustCredientialsDTO(CustomerCredientialsDTO custCredientialsDTO) {
		this.custCredientialsDTO = custCredientialsDTO;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
		
}
