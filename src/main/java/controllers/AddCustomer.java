package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.CustomerDao;
import model.Customer;

@Controller
public class AddCustomer {

	@Autowired
	private CustomerDao dao;
	@RequestMapping(path="/addCustomer",method=RequestMethod.POST)
	public String addCustomer(@RequestParam("name") String name,@RequestParam("address") String Address)
	{
		Customer cust = new Customer();
		cust.setName(name);
		cust.setAddress(Address);
		dao.addCustomer(cust);
		
		return "success";
	}
}
