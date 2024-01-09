package com.srm.spring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employeedetails")
public class EmployeeDetails {
	
	@Id
	@Column(name="empid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer empid;
	
	@Column(name="employeename")
	private String employeename;
	
	@Column(name="department")
	private String department;
	
	@Column(name="branchname")
	private String branchname;
	
	@Column(name="salary")
	private double salary;
	
	@Column(name="dob")
	private Date dob;

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getBranchname() {
		return branchname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	
}
