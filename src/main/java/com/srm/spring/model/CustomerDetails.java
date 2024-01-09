package com.srm.spring.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="customerdetails")
public class CustomerDetails {
	
	@Id
	@Column(name="custid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer custid;
	
	@Column(name="custname")
	private String custname;
	
	@Column(name="fathername")
	private String fathername;
	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="occupation")
	private String occupation;
	
	@Column(name="panno")
	private String panno;
	
	@Column(name="companyname")
	private String companyname;
	
	@Column(name="salary")
	private double salary;

	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "custid", insertable = false, updatable = false)
	private List<CustomerAddressDetails> custAddressDtlList;
		
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "custid", insertable = false, updatable = false)
	private CustomerCredientials customerCredientials;
	
	/*
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "custid", insertable = false, updatable = false)
	private CustomerCredientials customerCredientials;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "custid", insertable = false, updatable = false)
	private List<CurrentAccount> currentAccountList;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "custid", insertable = false, updatable = false)
	private List<SavingsAccount> savingsAccountList;
    */
	
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
		
	public List<CustomerAddressDetails> getCustAddressDtlList() {
		return custAddressDtlList;
	}

	public void setCustAddressDtlList(List<CustomerAddressDetails> custAddressDtlList) {
		this.custAddressDtlList = custAddressDtlList;
	}
	
	public CustomerCredientials getCustomerCredientials() {
		return customerCredientials;
	}

	public void setCustomerCredientials(CustomerCredientials customerCredientials) {
		this.customerCredientials = customerCredientials;
	}

	/*
	public CustomerCredientials getCustomerCredientials() {
		return customerCredientials;
	}

	public void setCustomerCredientials(CustomerCredientials customerCredientials) {
		this.customerCredientials = customerCredientials;
	}
   
	public List<CurrentAccount> getCurrentAccountList() {
		return currentAccountList;
	}

	public void setCurrentAccountList(List<CurrentAccount> currentAccountList) {
		this.currentAccountList = currentAccountList;
	}

	public List<SavingsAccount> getSavingsAccountList() {
		return savingsAccountList;
	}

	public void setSavingsAccountList(List<SavingsAccount> savingsAccountList) {
		this.savingsAccountList = savingsAccountList;
	}*/
		
}
