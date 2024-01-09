package com.srm.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.srm.spring.dao.CustomerAddressDAO;
import com.srm.spring.dao.CustomerCredientialsDAO;
import com.srm.spring.dao.CustomerDetailsDAO;
import com.srm.spring.dto.CustomerAddressDetailsDTO;
import com.srm.spring.dto.CustomerCredientialsDTO;
import com.srm.spring.dto.CustomerDetailsDTO;
import com.srm.spring.model.CustomerAddressDetails;
import com.srm.spring.model.CustomerCredientials;
import com.srm.spring.model.CustomerDetails;

@Component
public class CustomerDetailsService {
	
	@Autowired
	CustomerDetailsDAO customerDetailsDAO;
	
	@Autowired
	CustomerAddressDAO customerAddressDAO;
	
	@Autowired
	CustomerCredientialsDAO customerCredientialsDAO;
	
	@Transactional
	public CustomerDetailsDTO saveCustomerDetails(CustomerDetailsDTO custDtlsDTO)  throws Exception {
		
		CustomerDetails custDetails = new CustomerDetails();
		custDetails.setCustname(custDtlsDTO.getCustname());
		custDetails.setFathername(custDtlsDTO.getFathername());
		custDetails.setDob(custDtlsDTO.getDob());
		custDetails.setOccupation(custDtlsDTO.getOccupation());
		custDetails.setPanno(custDtlsDTO.getPanno());
		custDetails.setSalary(custDtlsDTO.getSalary());
		custDetails.setCompanyname(custDtlsDTO.getCompanyname());
		custDetails=customerDetailsDAO.saveCustomerDetails(custDetails);
		custDtlsDTO.setCustid(custDetails.getCustid());
		saveCustAddressDtls(custDtlsDTO.getCustAddressDtlsDTOList(),custDtlsDTO.getCustid());
		saveCustCredientialsDtls(custDtlsDTO.getCustCredientialsDTO(),custDtlsDTO.getCustid());
		return custDtlsDTO;
	}
	
	
	private List<CustomerAddressDetailsDTO> saveCustAddressDtls(List<CustomerAddressDetailsDTO> custAddList,Integer custId) throws Exception{
			
		for(CustomerAddressDetailsDTO dto :custAddList){
			CustomerAddressDetails custAddDtls = new CustomerAddressDetails();
			CustomerDetails custDetails = new CustomerDetails();
			custDetails.setCustid(custId);
			custAddDtls.setCustid(custDetails);
			custAddDtls.setAddresstype(dto.getAddresstype());
			custAddDtls.setAddress(dto.getAddress());
			custAddDtls.setStreet(dto.getStreet());
			custAddDtls.setCity(dto.getCity());
			custAddDtls.setPincode(dto.getPincode());
			custAddDtls=customerAddressDAO.saveCustomerAddressDetails(custAddDtls);
			dto.setAddressid(custAddDtls.getAddressid());
		}
		return custAddList;
	}
	
    private CustomerCredientialsDTO saveCustCredientialsDtls(CustomerCredientialsDTO custCredientialsDTO,Integer custId) throws Exception{
	   	CustomerCredientials obj = new CustomerCredientials();
	   	CustomerDetails custDetails = new CustomerDetails();
		custDetails.setCustid(custId);
	   	obj.setCustid(custDetails);
	   	obj.setUsername(custCredientialsDTO.getUsername());
	   	obj.setPassword(custCredientialsDTO.getPassword());
	   	obj.setAuthtoken(getAuthtoken());
	   	obj=customerCredientialsDAO.saveCustomerCredientials(obj);
	   	custCredientialsDTO.setCredientialid(obj.getCredientialid());
		return custCredientialsDTO;
	}
	
    @Transactional
    public CustomerDetailsDTO updateCustomerDetails(CustomerDetailsDTO custDtlsDTO)  throws Exception {
		
		CustomerDetails custDetails = new CustomerDetails();
		custDetails.setCustid(custDtlsDTO.getCustid());
		custDetails.setCustname(custDtlsDTO.getCustname());
		custDetails.setFathername(custDtlsDTO.getFathername());
		custDetails.setDob(custDtlsDTO.getDob());
		custDetails.setOccupation(custDtlsDTO.getOccupation());
		custDetails.setPanno(custDtlsDTO.getPanno());
		custDetails=customerDetailsDAO.updateCustomerDetails(custDetails);
		custDtlsDTO.setCustid(custDetails.getCustid());
		updateCustAddressDtls(custDtlsDTO.getCustAddressDtlsDTOList(),custDtlsDTO.getCustid());
		updateCustCredientialsDtls(custDtlsDTO.getCustCredientialsDTO(),custDtlsDTO.getCustid());
		return custDtlsDTO;
	}
	
	private List<CustomerAddressDetailsDTO> updateCustAddressDtls(List<CustomerAddressDetailsDTO> custAddList,Integer custId) throws Exception{
			
		for(CustomerAddressDetailsDTO dto :custAddList){
			CustomerAddressDetails custAddDtls = new CustomerAddressDetails();
			CustomerDetails custDetails = new CustomerDetails();
			custAddDtls.setAddressid(custAddDtls.getAddressid());
			custDetails.setCustid(custId);
			custAddDtls.setCustid(custDetails);
			custAddDtls.setAddresstype(custAddDtls.getAddresstype());
			custAddDtls.setAddress(dto.getAddress());
			custAddDtls.setStreet(dto.getStreet());
			custAddDtls.setCity(dto.getCity());
			custAddDtls.setPincode(dto.getPincode());
			custAddDtls=customerAddressDAO.updateCustomerAddressDetails(custAddDtls);
			dto.setAddressid(custAddDtls.getAddressid());
		}
		return custAddList;
	}
	
    private CustomerCredientialsDTO updateCustCredientialsDtls(CustomerCredientialsDTO custCredientialsDTO,Integer custId) throws Exception{
	   	CustomerCredientials obj = new CustomerCredientials();
	   	CustomerDetails custDetails = new CustomerDetails();
		custDetails.setCustid(custId);
		obj.setCredientialid(custCredientialsDTO.getCredientialid());
	   	obj.setCustid(custDetails);
	   	obj.setUsername(custCredientialsDTO.getUsername());
	   	obj.setPassword(custCredientialsDTO.getPassword());
	   	obj=customerCredientialsDAO.updateCustomerCredientials(obj);
	   	custCredientialsDTO.setCredientialid(obj.getCredientialid());
		return custCredientialsDTO;
	}
    
    
    @Transactional
    public List<CustomerDetailsDTO> retrieveAllCustomerDetails(){
      	List<CustomerDetailsDTO> customerDetailDTOList = new ArrayList<CustomerDetailsDTO>();
    	List<CustomerDetails> customerDetailsList = customerDetailsDAO.retrieveAllCustomerDetails();
    	for(CustomerDetails custModel:customerDetailsList){
    		CustomerDetailsDTO dto = new CustomerDetailsDTO();
    		dto.setCustid(custModel.getCustid());
    		dto.setCustname(custModel.getCustname());
    		dto.setFathername(custModel.getFathername());
    		dto.setDob(custModel.getDob());
    		dto.setCompanyname(custModel.getCompanyname());
    		dto.setOccupation(custModel.getOccupation());
    		dto.setSalary(custModel.getSalary());
    		dto.setPanno(custModel.getPanno());
    		customerDetailDTOList.add(dto);
    	}
    	return customerDetailDTOList;
    }
    
    @Transactional
    public List<CustomerAddressDetailsDTO> retrieveCustomerAddressDetailsByCustId(Integer custid) throws Exception{
    	List<CustomerAddressDetailsDTO> addressDtoList = new ArrayList<CustomerAddressDetailsDTO>();
    	List<CustomerAddressDetails> custAddressList=customerDetailsDAO.retrieveCustomerAddressDetailsByCustId(custid);
    	for(CustomerAddressDetails model:custAddressList){
    		CustomerAddressDetailsDTO dto = new CustomerAddressDetailsDTO();
    		dto.setAddressid(model.getAddressid());
    		dto.setAddresstype(model.getAddresstype());
    		dto.setAddress(model.getAddress());
    		dto.setStreet(model.getStreet());
    		dto.setCity(model.getCity());
    		dto.setPincode(model.getPincode());
    		addressDtoList.add(dto);
    	}
    	return addressDtoList;
    }
    
    @Transactional
    public CustomerCredientialsDTO retrieveCustomerCredientialsByCustId(Integer custid) throws Exception{
    	CustomerCredientialsDTO dto = new CustomerCredientialsDTO();
    	CustomerCredientials credientialsModel=customerDetailsDAO.retrieveCustomerCredientialsByCustId(custid);
    	if(credientialsModel!=null){
    		dto.setCredientialid(credientialsModel.getCredientialid());
    		dto.setCustid(credientialsModel.getCustid().getCustid());
    		dto.setUsername(credientialsModel.getUsername());
    		dto.setPassword(credientialsModel.getPassword());
    	}
    	return dto;
    }
    
    	
    @Transactional
    public CustomerDetailsDTO retrieveCustomerDetailsByCustId(Integer custid) throws Exception{
    	
    	List<CustomerAddressDetailsDTO> custAddressDtlsDTOList = new  ArrayList<CustomerAddressDetailsDTO>();
    	CustomerDetailsDTO dto = new CustomerDetailsDTO();
    	CustomerDetails custDetails= customerDetailsDAO.retrieveCustomerDetailsByCustId(custid);
    	dto.setCustid(custDetails.getCustid());
    	dto.setCustname(custDetails.getCustname());
    	dto.setFathername(custDetails.getFathername());
    	dto.setDob(custDetails.getDob());
    	dto.setOccupation(custDetails.getOccupation());
    	dto.setPanno(custDetails.getPanno());
    	dto.setCompanyname(custDetails.getCompanyname());
    	dto.setSalary(custDetails.getSalary());
      	List<CustomerAddressDetails> custAddressDtlList = custDetails.getCustAddressDtlList();
    	for(CustomerAddressDetails obj:custAddressDtlList){
    		
    		CustomerAddressDetailsDTO addressdto = new CustomerAddressDetailsDTO();
    		
    		addressdto.setAddressid(obj.getAddressid());
    		addressdto.setAddresstype(obj.getAddresstype());
    		addressdto.setAddress(obj.getAddress());
    		addressdto.setStreet(obj.getStreet());
    		addressdto.setCity(obj.getCity());
    		addressdto.setCustid(obj.getCustid().getCustid());
    		addressdto.setPincode(obj.getPincode());
    		custAddressDtlsDTOList.add(addressdto);
    		
    	}
    	 
    	dto.setCustAddressDtlsDTOList(custAddressDtlsDTOList);
    	return dto;
    }
    
    @Transactional
    public CustomerDetailsDTO retrieveCustomerAndCredientialDtls(Integer custid) throws Exception{
    	   return customerDetailsDAO.retrieveCustomerAndCredientialDtls(custid);
    }
    
    @Transactional
    public CustomerDetailsDTO retrieveCustomerAndCredientialDtlsByCriteria(Integer custid) throws Exception{
    	return customerDetailsDAO.retrieveCustomerAndCredientialDtlsByCriteria(custid);
    }
    
    
    
    @Transactional
    public CustomerDetailsDTO retrieveCustomerByHQL(Integer custid) throws Exception{
    	return customerDetailsDAO.retrieveCustomerByHQL(custid);
    }
    
    @Transactional
    public String updateCustomerDetailsbyHQL(CustomerDetailsDTO custDtlsDto) throws Exception{
    	CustomerDetails custDetails = new CustomerDetails();
    	custDetails.setCustid(custDtlsDto.getCustid());
    	custDetails.setFathername(custDtlsDto.getFathername());
    	custDetails.setOccupation(custDtlsDto.getOccupation());
    	custDetails.setPanno(custDtlsDto.getPanno());
    	return customerDetailsDAO.updateCustomerDetailsbyHQL(custDetails);
    }
    
    @Transactional
    public String deleteCustomerDetailsbyHQL(Integer custid) throws Exception{
    	return customerDetailsDAO.deleteCustomerDetailsbyHQL(custid);
    }
    
    @Transactional
    public CustomerDetailsDTO getCustomerDetailsByNamedQuery(Integer custId) throws Exception{
    	CustomerDetails custdetails;
    	custdetails= customerDetailsDAO.getCustomerDetailsByNamedQuery(custId);
    	CustomerDetailsDTO dto = new CustomerDetailsDTO();
    	dto.setCustid(custdetails.getCustid());
    	dto.setCustname(custdetails.getCustname());
    	dto.setFathername(custdetails.getFathername());
    	dto.setDob(custdetails.getDob());
    	dto.setOccupation(custdetails.getOccupation());
    	dto.setPanno(custdetails.getPanno());
    	return dto;
    }
    
    private String getAuthtoken(){
    	String token = UUID.randomUUID().toString();
    	return token;
    }
    
    @Transactional
    public int deleteCustomerDetailsByCustId(Integer custId) throws Exception{
    	int deleteStatus = 0;
    	try{
    		int customerCredientialsStatus=customerCredientialsDAO.deleteCustomerCredientialsByCustId(custId);
    		int addressDeleteStatus=customerAddressDAO.deleteCustomerAddressDetailsByCustId(custId);
    		int custDeleteStatus=customerDetailsDAO.deleteCustomerDetailsByCustId(custId);
    		if(custDeleteStatus>0&&addressDeleteStatus>0&&customerCredientialsStatus>0){
    			deleteStatus=1;
    		}
      	}catch(Exception ex){
    		throw ex;
    	}
    	return deleteStatus;
    }
    

}
