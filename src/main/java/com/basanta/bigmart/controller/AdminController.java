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
@RequestMapping("/admin")
public class AdminController {
	
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private ProductRepo productRepo;
	
	@RequestMapping("/index")
	public ModelAndView dashboard() {
		
		ModelAndView model = new ModelAndView("/admin/index");
		model.addObject("title", "Bigmart| Admin Dashboard");
		return model;
	}
	
	@RequestMapping("/addProduct")
	public ModelAndView addProduct() {
		
		ModelAndView model = new ModelAndView("/admin/add_product");
		model.addObject("title", "Bigmart| Add Product");
		return model;
	}
	
	@PostMapping("/saveProduct")
	public ModelAndView saveProduct(@RequestParam("product_code") String product_code,
									@RequestParam("product_name") String product_name,
									@RequestParam("product_price") String product_price) {
		
		ModelAndView model = new ModelAndView("/admin/add_product");
		model.addObject("title", "Bigmart| Add Product");
		Product saveProduct = new Product();
		
		saveProduct.setProduct_code(product_code);
		saveProduct.setProduct_name(product_name);
		saveProduct.setProduct_price(product_price);
		
		System.out.println(saveProduct.getProduct_price());
		
		this.productRepo.save(saveProduct);
		return model;
	}
	
	@RequestMapping("/viewProduct")
	public ModelAndView viewProduct()
	{
		ModelAndView model = new ModelAndView("/admin/view_product");
		List<Product> listProduct = this.productRepo.findAll();
		
		model.addObject("title", "Bigmart|View Products");
		model.addObject("product", listProduct);
		return model;
	}
	
	

}
