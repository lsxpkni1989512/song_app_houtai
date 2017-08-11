package owa.com.platform.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import owa.com.platform.entity.Customer;
import owa.com.platform.service.CustomService;
@Controller
@RequestMapping("/customerController")
public class CustomerController{
	
	
	private CustomService customerService;
	
	
	
	public CustomService getCustomerService() {
		return customerService;
	}


	@Autowired
	public void setCustomerService(CustomService customerService) {
		this.customerService = customerService;
	}



	@RequestMapping("/oneCustomer/{cunstomId}")
	public String getOneCustomer(@PathVariable short cunstomId,Map<String,Object> map){
		
		Customer c= customerService.getCustom(cunstomId);
		
		map.put("customer", c);
		
		return "oneCustomer";
			
	}


}
