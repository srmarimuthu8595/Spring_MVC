package com.srm.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customercredientials")
public class CustomerCredientials {
	
	@Id
	@Column(name="credientialid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer credientialid;
	
	@OneToOne
	@JoinColumn(name = "custid")
	private CustomerDetails custid;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "isAdmin")
	private String isAdmin;
	
	@Column(name="authtoken")
	private String authtoken;

	public Integer getCredientialid() {
		return credientialid;
	}

	public void setCredientialid(Integer credientialid) {
		this.credientialid = credientialid;
	}

	public CustomerDetails getCustid() {
		return custid;
	}

	public void setCustid(CustomerDetails custid) {
		this.custid = custid;
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
	
	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getAuthtoken() {
		return authtoken;
	}

	public void setAuthtoken(String authtoken) {
		this.authtoken = authtoken;
	}
	
	
}
