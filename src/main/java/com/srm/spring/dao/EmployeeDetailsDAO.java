package com.srm.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.srm.spring.model.EmployeeDetails;

@Repository
public class EmployeeDetailsDAO {
	

	@Autowired
	SessionFactory sessionFactory;
	
	
	public EmployeeDetails saveEmployeeDetails(EmployeeDetails empModel){
		try{
			Session session = sessionFactory.getCurrentSession();
			session.save(empModel);
		}catch(Exception ex){
			throw ex;
		}
		return empModel;
	}
	
	public List<EmployeeDetails> getAllEmployeeDetails() throws Exception{
		List<EmployeeDetails> employeeDtlList=null;
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("From EmployeeDetails");
			employeeDtlList=(List<EmployeeDetails>)query.list();
		} catch (Exception ex) {
			throw ex;
		}
		return employeeDtlList;
	}

}
