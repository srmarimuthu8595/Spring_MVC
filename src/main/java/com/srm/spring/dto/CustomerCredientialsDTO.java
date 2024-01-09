package com.srm.spring.dto;

import com.srm.spring.model.CustomerDetails;

public class CustomerCredientialsDTO {
		
	private Integer credientialid;
	
	private Integer custid;
	
	private String customerName;
	
	private String username;

	private String password;
	
	private String authtoken;
	
	private String status;
	
	private String isAdmin;
	

	public Integer getCredientialid() {
		return credientialid;
	}

	public void setCredientialid(Integer credientialid) {
		this.credientialid = credientialid;
	}

	public Integer getCustid() {
		return custid;
	}

	public void setCustid(Integer custid) {
		this.custid = custid;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
		
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthtoken() {
		return authtoken;
	}

	public void setAuthtoken(String authtoken) {
		this.authtoken = authtoken;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
}
