package com.srm.spring.dao;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.srm.spring.model.CustomerAddressDetails;


@Repository
public class CustomerAddressDAO {
	
	
	@Autowired
	SessionFactory sessionFactory;
	
	public CustomerAddressDetails saveCustomerAddressDetails(CustomerAddressDetails custadddtls) throws Exception{
		try{
			Session session = sessionFactory.getCurrentSession();
			session.save(custadddtls);
			}catch(Exception ex){
			throw ex;
		}
		return custadddtls;
	}
	
	public CustomerAddressDetails updateCustomerAddressDetails(CustomerAddressDetails custadddtls) throws Exception{
		try{
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(custadddtls);
		}catch(Exception ex){
			throw ex;
		}
		return custadddtls;
	}
	
	public int deleteCustomerAddressDetailsByCustId(Integer custId) throws Exception {
		int deleteStatus = 0;
		try{
			Session session = sessionFactory.getCurrentSession();
			String deleteQuery="delete from customeraddressdetails where custid="+custId;
		    SQLQuery sqlQuery = session.createSQLQuery(deleteQuery); 
		    deleteStatus=sqlQuery.executeUpdate();
		}catch(Exception ex){
			throw ex;
		}
		return deleteStatus;
	}
	
	
	
	
	

}
