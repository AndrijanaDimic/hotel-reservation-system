package com.raf.restdemo.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.raf.restdemo.service.ProductService;

@Component
public class SimpleScheduler {

	private ProductService productService;
	
	public SimpleScheduler(ProductService productService) {
		this.productService = productService;
	}
	@Scheduled(fixedDelay =  10000, initialDelay = 10000)
	public void printAllProductsFromDataBase() {
		System.out.println("PRINT ALL SCHEDUELERR");
		productService.printAllProducts();
	}
}
