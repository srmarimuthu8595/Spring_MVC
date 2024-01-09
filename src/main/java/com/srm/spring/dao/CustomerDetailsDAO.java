package com.srm.spring.dao;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.srm.spring.dto.CustomerCredientialsDTO;
import com.srm.spring.dto.CustomerDetailsDTO;
import com.srm.spring.model.CustomerDetails;
import com.srm.spring.model.CustomerCredientials;
import com.srm.spring.model.CustomerAddressDetails;

@Repository
public class CustomerDetailsDAO {

	@Autowired
	SessionFactory sessionFactory;

	public CustomerDetails saveCustomerDetails(CustomerDetails custdtls) throws Exception {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(custdtls);
		} catch (Exception ex) {
			throw ex;
		}
		return custdtls;
	}

	public CustomerDetails updateCustomerDetails(CustomerDetails custdtls) throws Exception {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(custdtls);
		} catch (Exception ex) {
			throw ex;
		}
		return custdtls;
	}
	
	public List<CustomerDetails> retrieveAllCustomerDetails(){
		List<CustomerDetails> customerList;
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("FROM CustomerDetails");
			customerList =(List<CustomerDetails>)query.list();
		} catch (Exception ex) {
			throw ex;
		}
		return customerList;
	}
	
	public List<CustomerAddressDetails> retrieveCustomerAddressDetailsByCustId(Integer custid) throws Exception {
		 List<CustomerAddressDetails> addressList;
		try {
				Session session = sessionFactory.getCurrentSession();
				Query query = session.createQuery("FROM CustomerAddressDetails cust where cust.custid="+custid);
				addressList=(List<CustomerAddressDetails>)query.list();
				
		 }catch(Exception ex){
			throw ex; 
		 }
		return addressList;		
	}
	
	
	public CustomerCredientials retrieveCustomerCredientialsByCustId(Integer custid) throws Exception{
		CustomerCredientialsDTO custDetailsDTO= new CustomerCredientialsDTO();
		CustomerCredientials credDetails = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("FROM CustomerCredientials cust WHERE cust.custid="+custid);
			List<CustomerCredientials> list =(List<CustomerCredientials>)query.list();
			if(list!=null&&list.size()>0){
				credDetails=credDetails=list.get(0);
			}
		}catch(Exception ex){
			throw ex;
		}
		return credDetails;
	}
	
	public CustomerDetails retrieveCustomerDetailsByCustId(Integer custid) throws Exception {
		CustomerDetails obj;
		try {
			Session session = sessionFactory.getCurrentSession();
			obj = (CustomerDetails) session.get(CustomerDetails.class, custid);
		} catch (Exception ex) {
			throw ex;
		}
		return obj;
	}

	public CustomerDetailsDTO retrieveCustomerAndCredientialDtls(Integer custid) throws Exception {
		CustomerDetailsDTO custDtls = new CustomerDetailsDTO();
		CustomerCredientialsDTO crediential = new CustomerCredientialsDTO();
		try {

			Session session = sessionFactory.getCurrentSession();

			String querystr = "Select cust.custid,cust.custname,cust.fathername,cust.dod,cust.occupation,cust.panno,"
					+ "crd.credientialid,crd.username,crd.password"
					+ " from CustomerDetails cust join CustomerCredientials crd on cust.custid=crd.custid and cust.custid="
					+ custid;

			Query<?> query = session.createSQLQuery(querystr);
			List<Object[]> result = (List<Object[]>) query.list();

			for (Object[] object : result) {

				custDtls.setCustid(new Integer(object[0].toString()));
				custDtls.setCustname(object[1].toString());
				custDtls.setFathername(object[2].toString());
				// Date dob=(Date) new SimpleDateFormat("yyyy-MM-dd
				// HH:mm:ss").parse(object[3].toString());
				// custDtls.setDod(dob);
				// custDtls.setDod(Date.valueOf(object[3].toString()));
				custDtls.setOccupation(object[4].toString());
				custDtls.setPanno(object[5].toString());
				crediential.setCredientialid(new Integer(object[6].toString()));
				crediential.setUsername(object[7].toString());
				crediential.setPassword(object[8].toString());
			}

			custDtls.setCustCredientialsDTO(crediential);

		} catch (Exception ex) {
			throw ex;
		}
		return custDtls;
	}
	
	
	public CustomerDetailsDTO retrieveCustomerAndCredientialDtlsByCriteria(Integer custid) throws Exception{
		CustomerDetailsDTO custDtls = new CustomerDetailsDTO();
		CustomerCredientialsDTO crediential = new CustomerCredientialsDTO();
		try{
			
			Session session = sessionFactory.getCurrentSession();

			CriteriaBuilder crBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Object[]> criteriaQuery = crBuilder.createQuery(Object[].class);
			Root<CustomerDetails> custRoot = criteriaQuery.from(CustomerDetails.class);
			Root<CustomerCredientials> credientialsRoot = criteriaQuery.from(CustomerCredientials.class);
			criteriaQuery.multiselect(custRoot, credientialsRoot);
	        criteriaQuery.where(crBuilder.equal(custRoot.get("custid"), credientialsRoot.get("custid")),crBuilder.equal(custRoot.get("custid"),custid));
					
	        Query<Object[]> query=session.createQuery(criteriaQuery);
			List<Object[]> result = (List<Object[]>) query.list();
			
			for(Object[] object : result){
				
				CustomerDetails custobj =(CustomerDetails)object[0];
				CustomerCredientials credientialobj =(CustomerCredientials)object[1];
				
				custDtls.setCustid(custobj.getCustid());
				custDtls.setCustname(custobj.getCustname());
				custDtls.setFathername(custobj.getFathername());
				custDtls.setDob(custobj.getDob());
				custDtls.setOccupation(custobj.getOccupation());
				custDtls.setPanno(custobj.getPanno());
				crediential.setCredientialid(credientialobj.getCredientialid());
				crediential.setUsername(credientialobj.getUsername());
				crediential.setPassword(credientialobj.getPassword());
		
			}
				
			custDtls.setCustCredientialsDTO(crediential);
			
		}catch(Exception ex){
			throw ex;
		}
		return custDtls;
	}
	
	

	public CustomerDetailsDTO retrieveCustomerByHQL(Integer custid) throws Exception {
		CustomerDetailsDTO custDtls = new CustomerDetailsDTO();
		try {

			Session session = sessionFactory.getCurrentSession();

			String querystr = "FROM CustomerDetails cust WHERE cust.custid=" + custid;

			Query<?> query = session.createQuery(querystr);
			List<CustomerDetails> result = (List<CustomerDetails>) query.list();

			for (CustomerDetails custobj : result) {

				custDtls.setCustid(custobj.getCustid());
				custDtls.setCustname(custobj.getCustname());
				custDtls.setCustname(custobj.getFathername());
				custDtls.setDob(custobj.getDob());
				custDtls.setOccupation(custobj.getOccupation());
				custDtls.setPanno(custobj.getPanno());

			}

		} catch (Exception ex) {
			throw ex;
		}
		return custDtls;
	}

	public String updateCustomerDetailsbyHQL(CustomerDetails custdtls) throws Exception {
		String status = null;
		try {

			Session session = sessionFactory.getCurrentSession();
			int updatedEntities = session
					.createQuery("UPDATE CustomerDetails " + "SET occupation = :occupation,panno=:panno "
							+ "where custid=:custid")
					.setParameter("custid", custdtls.getCustid()).setParameter("occupation", custdtls.getOccupation())
					.setParameter("panno", custdtls.getPanno()).executeUpdate();
			//session.getTransaction().commit();
			if (updatedEntities > 0) {
				status = "Customer details updated successfully";
			} else {
				status = "Customer details not updated successfully";
			}

		} catch (Exception ex) {
			status = "Customer details not updated successfully";
			throw ex;
		}
		return status;
	}

	public String deleteCustomerDetailsbyHQL(Integer custid) throws Exception {
		String status = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			CustomerDetails custobj = new CustomerDetails();
			custobj.setCustid(custid);
			
			session.createQuery("DELETE CustomerCredientials" + " where custid=:custid").setParameter("custid", custobj).executeUpdate();
			
			session.createQuery("DELETE CustomerAddressDetails" + " where custid=:custid").setParameter("custid", custobj).executeUpdate();
			
			session.createQuery("DELETE CustomerDetails where custid=:custid").setParameter("custid",custid).executeUpdate();
			
			//session.getTransaction().commit();
			
			status = "Customer details deleted successfully";
		} catch (Exception ex) {
			status = "Customer details not deleted successfully";
			throw ex;
		}
		return status;

	}
	
	
	public CustomerDetails getCustomerDetailsByNamedQuery(Integer custId){
		CustomerDetails custDetails = null;
		try{
			
			Session session = sessionFactory.getCurrentSession();
			Query query = session.getNamedQuery("CustomerDetails.findByCustId").setParameter("custid",custId); 
			List<CustomerDetails> resultList = (List<CustomerDetails>) query.list();
			if(resultList!=null&&resultList.size()>0){
				custDetails=resultList.get(0);
			}
				
					
	     }catch(Exception ex){
	    	 throw ex; 
	     }
		return custDetails;
	}
	
	
	public int deleteCustomerDetailsByCustId(Integer custId) throws Exception {
		int deletedStatus;
		try{
			Session session = sessionFactory.getCurrentSession();
			String deleteQuery="delete from customerdetails where custId="+custId;
			SQLQuery sqlquery = session.createSQLQuery(deleteQuery);
			deletedStatus=sqlquery.executeUpdate();
			
		}catch(Exception ex){
		  throw ex;	
		}
		return deletedStatus;
	}
		
}
