package com.srm.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.srm.spring.dto.CustomerCredientialsDTO;
import com.srm.spring.model.CustomerCredientials;

@Repository
public class LoginDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public CustomerCredientialsDTO doLogin(CustomerCredientials object) throws Exception{
		CustomerCredientialsDTO credientialsObjDTO = new CustomerCredientialsDTO();
		try{
			Session session = sessionFactory.getCurrentSession();
			Query<?> query= session.createSQLQuery("Select a.custname,b.username,b.password,b.authtoken,b.isadmin from customerdetails a, customercredientials b where a.custid=b.custid and  b.username='"+object.getUsername()+"' and b.password='"+object.getPassword()+"'");
			List<Object[]> result = (List<Object[]>) query.list();
			if(result.isEmpty()!=true){
			    for (Object[] resultObject : result) {
			    	credientialsObjDTO.setCustomerName(resultObject[0].toString());
			    	credientialsObjDTO.setUsername(resultObject[1].toString());
			    	credientialsObjDTO.setPassword(resultObject[2].toString());
				    credientialsObjDTO.setAuthtoken(resultObject[3].toString());
			    	credientialsObjDTO.setIsAdmin(resultObject[4].toString());
				}
			
			    if(credientialsObjDTO.getUsername().equals(object.getUsername())&&credientialsObjDTO.getPassword().equals(object.getPassword())){
			    	credientialsObjDTO.setStatus("Login success");
			    }else{
					credientialsObjDTO.setStatus("Login not success due to invalid username and password");
				}
			}
		}catch(Exception exxx){
			throw exxx;
		} triggers { pollSCM 'H/5 * * * *' }
		return 	credientialsObjDTO;		
	}
	
	

}
