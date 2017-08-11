package owa.com.platform.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import owa.com.platform.dao.CustomerDao;
import owa.com.platform.entity.Customer;
import owa.com.platform.service.CustomService;
@Service("customService")
public class CustomServiceIml implements CustomService{
	
	@Autowired
	private CustomerDao custom;


	public Customer getCustom(short customerId) {
		// TODO Auto-generated method stub
		return custom.selectByPrimaryKey(customerId);
		
	}	
}
