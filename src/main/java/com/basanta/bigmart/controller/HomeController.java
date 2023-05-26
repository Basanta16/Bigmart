package com.basanta.bigmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.basanta.bigmart.entity.Customer;
import com.basanta.bigmart.entity.Product;
import com.basanta.bigmart.repository.CustomerRepo;
import com.basanta.bigmart.repository.ProductRepo;

@RestController
public class HomeController {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private ProductRepo productRepo;
	
	
	@RequestMapping("/")
	public ModelAndView dashboard()
	{
		ModelAndView model = new ModelAndView("index");
		model.addObject("title", "Bigmart|Home");
		return model;
	}
	
	@RequestMapping("/about")
	public ModelAndView about()
	{
		ModelAndView model = new ModelAndView("about");
		model.addObject("title", "Bigmart|About");
		return model;
	}
	@RequestMapping("/service")
	public ModelAndView service()
	{
		ModelAndView model = new ModelAndView("service");
		model.addObject("title", "Bigmart|Service");
		return model;
	}
	
	@RequestMapping("/customers")
	public ModelAndView customer()
	{
		ModelAndView model = new ModelAndView("add_customers");
		model.addObject("title", "Bigmart|Add Customers");
		return model;
	}
	
	@PostMapping("/saveCustomer")
	public ModelAndView savecustomer(@RequestParam("name") String name,
									@RequestParam("address") String address,
									@RequestParam("email") String email, @RequestParam("phone") String phone)
	{
		ModelAndView model = new ModelAndView("add_customers");
		model.addObject("title", "Bigmart|Add Customers");
		
		Customer savecus = new Customer();
		
		savecus.setName(name);
		savecus.setAddress(address);
		savecus.setEmail(email);
		savecus.setPhone(phone);
		
		this.customerRepo.save(savecus);
		
		return model;
	}
	
	@RequestMapping("/viewCustomer")
	public ModelAndView viewcustomer()
	{
		ModelAndView model = new ModelAndView("view_customers");
		List<Customer> listCustomer = this.customerRepo.findAll();
		
		model.addObject("title", "Bigmart|View Customers");
		model.addObject("customer", listCustomer);
		return model;
	}
	
	@PostMapping("/chooseProduct")
	public ModelAndView chooseProduct(@RequestParam("product_code") String product_code)
	{
		ModelAndView model = new ModelAndView("service");
		model.addObject("title", "Bigmart|Add Customers");
		
		 Product product =   this.productRepo.findByproductCode(product_code);
		 
		 System.out.println("Product name: " + product.getProduct_name());
		 System.out.println("Product Price: " + product.getProduct_price());
		
		return model;
	}
	
}
