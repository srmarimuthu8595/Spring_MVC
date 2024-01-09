package com.srm.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.srm.spring.dto.CustomerAddressDetailsDTO;
import com.srm.spring.dto.CustomerCredientialsDTO;
import com.srm.spring.dto.CustomerDetailsDTO;
import com.srm.spring.service.CustomerDetailsService;

@RestController
@RequestMapping(value = "/rest/custdtl")
public class CustomerDetailsController {
	
	@Autowired
	private CustomerDetailsService customerDetailsService;
	
	@RequestMapping(value = "/savecustomerdtls", method = RequestMethod.POST)
	public @ResponseBody CustomerDetailsDTO saveCustomerDetails(@RequestBody CustomerDetailsDTO custDtlsDto){
		try{
			custDtlsDto=customerDetailsService.saveCustomerDetails(custDtlsDto);
			custDtlsDto.setStatus("Customer details saved successfully");
		}catch(Exception ex){
			custDtlsDto.setStatus("Customer details not saved successfully");
			ex.printStackTrace();
		}
	   return custDtlsDto;
	}
	
	@RequestMapping(value = "/updatecustomerdtls", method = RequestMethod.POST)
	public @ResponseBody CustomerDetailsDTO updateCustomerDetails(@RequestBody CustomerDetailsDTO custDtlsDto){
		try{
			custDtlsDto=customerDetailsService.updateCustomerDetails(custDtlsDto);
			custDtlsDto.setStatus("Customer details updated successfully");
		}catch(Exception ex){
			custDtlsDto.setStatus("Customer details not updated successfully");
			ex.printStackTrace();
		}
	   return custDtlsDto;
	}
	
	@RequestMapping(value = "/retrieveAllCustomerDetails", method = RequestMethod.GET)
	public @ResponseBody List<CustomerDetailsDTO> retrieveAllCustomerDetails(){
		List<CustomerDetailsDTO> customerDetailDTOList=null;
		try{
			customerDetailDTOList=customerDetailsService.retrieveAllCustomerDetails();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	   return customerDetailDTOList;
	}
	
	@RequestMapping(value = "/retrieveCustomerAddressDetailsByCustId", method = RequestMethod.GET)
	public @ResponseBody List<CustomerAddressDetailsDTO> retrieveCustomerAddressDetailsByCustId(@RequestParam("custid")Integer custid){
		List<CustomerAddressDetailsDTO> custAddressDTList=null;
		try{
			custAddressDTList=customerDetailsService.retrieveCustomerAddressDetailsByCustId(custid);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return custAddressDTList;
	}
	
	
	
	
	
	
	
	@RequestMapping(value = "/retrieveCustomerCredientialsByCustId", method = RequestMethod.GET)
	public @ResponseBody CustomerCredientialsDTO getCustomerCredientialsByCustId(@RequestParam("custid")Integer custid){
		CustomerCredientialsDTO credientialDto=null;
		try{
			credientialDto=customerDetailsService.retrieveCustomerCredientialsByCustId(custid);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return credientialDto;	
	}
	
	@RequestMapping(value = "/retrievecustomerandcredientials", method = RequestMethod.GET)
	public @ResponseBody CustomerDetailsDTO retrieveCustomerAndCredientialDtls(@RequestParam("custid")Integer custid){
		CustomerDetailsDTO custDto=null;
		try{
			custDto=customerDetailsService.retrieveCustomerAndCredientialDtls(custid);
		}catch(Exception ex){
			ex.printStackTrace();
		} 	  
		return custDto;  
		  
	}
				
	@RequestMapping(value = "/retrieveCustomerDetailsbyCustId", method = RequestMethod.GET)
	public @ResponseBody CustomerDetailsDTO retrieveCustomerDetailsByCustId(@RequestParam("custid")Integer custid){
		CustomerDetailsDTO custDto = null;
		try{
			custDto=customerDetailsService.retrieveCustomerDetailsByCustId(custid);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	   return custDto;
	}

	 @RequestMapping(value = "/retrieveCustomerAndCredientialDtlsByCriteria", method = RequestMethod.GET)
	 public CustomerDetailsDTO retrieveCustomerAndCredientialDtlsByCriteria(@RequestParam("custid") Integer custid) throws Exception{
		 CustomerDetailsDTO custDto=null;
			try{
				custDto=customerDetailsService.retrieveCustomerAndCredientialDtlsByCriteria(custid);
			}catch(Exception ex){
				ex.printStackTrace();
			} 	  
			return custDto;  
	 }
	
	@RequestMapping(value = "/retrieveCustomerByHQL", method = RequestMethod.GET)
    public @ResponseBody CustomerDetailsDTO retrieveCustomerByHQL(@RequestParam("custid")Integer custid){
		CustomerDetailsDTO custDto=null;
		try{
			custDto=customerDetailsService.retrieveCustomerByHQL(custid);
		}catch(Exception ex){
			ex.printStackTrace();
		} 	  
		return custDto;  
	}
	
	 @RequestMapping(value = "/updateCustomerDetailsbyHQL", method = RequestMethod.POST)
	 public @ResponseBody String updateCustomerDetailsbyHQL(@RequestBody CustomerDetailsDTO custDtlsDto){
		  String status=null;
			try{
				status=customerDetailsService.updateCustomerDetailsbyHQL(custDtlsDto);
			}catch(Exception ex){
				ex.printStackTrace();
			} 	  
		return status;  
		 	 
	 }
	
	 @RequestMapping(value = "/deleteCustomerDetailsbyHQL", method = RequestMethod.POST)
	 public String deleteCustomerDetailsbyHQL(@RequestParam("custid")Integer custid) {
		  String status=null;
			try{
				status=customerDetailsService.deleteCustomerDetailsbyHQL(custid);
			}catch(Exception ex){
				ex.printStackTrace();
			} 	  
		return status;  
	}
	 
	 @RequestMapping(value = "/getCustomerDetailsByNamedQuery", method = RequestMethod.GET)
	 public CustomerDetailsDTO getCustomerDetailsByNamedQuery(Integer custId){
		 CustomerDetailsDTO dto=null;
			try{
				dto=customerDetailsService.getCustomerDetailsByNamedQuery(custId);
			}catch(Exception ex){
				ex.printStackTrace();
			} 	  
		 return dto;
	 }
	 
	 @RequestMapping(value = "/deleteCustomerDetailsByCustId", method = RequestMethod.POST)
	 public String deleteCustomerDetailsByCustId(@RequestParam("custid")Integer custid) throws Exception{
		 String deleteStatus="";
		 try{
			int deleteServicestatus=customerDetailsService.deleteCustomerDetailsByCustId(custid);
			if(deleteServicestatus==1){
				deleteStatus="Customer details deleted successfully";	
			}
		 }catch(Exception ex){
			deleteStatus="Customer details no deleted successfully";
			throw ex;
		 }
		 return deleteStatus;
	 }
	 
	 
	 
	 
}
