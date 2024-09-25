package com.example.demo.controllers;

import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class BuyNowController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/buyNow")
	public String buyNow(@RequestParam("productID")Long id, Model theModel) {
		Optional<Product> productBought=productRepository.findById(id);
		if(productBought.isPresent()) {
			Product product=productBought.get();
			if(product.getInv()>0){
				product.setInv(product.getInv()-1);
				productRepository.save(product);
				return "/buysuccess";
			}else{
				return "/buyfail";
			}
		}else{
			return "/buyfail";
		}
	}
}
