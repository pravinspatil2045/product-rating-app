package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.model.ProductRating;
import com.example.demo.service.RatingService;

@RestController
@RequestMapping("/api/v1")
public class RatingController {
	
	@Autowired
	RatingService ratingService;
	
	@GetMapping("/products/{productId}/ratings")
	public Product getProductRating(@PathVariable("productId") int productId) {
		
		System.out.println("RatingController getProductRating() : ");
		return ratingService.getProductRating(productId);
	}
	
	@PostMapping("/products/{productId}/ratings/{rating}")
	public ProductRating addProductRating(@PathVariable("productId") int productId, @PathVariable("rating") int rating) {
		
		System.out.println("RatingController addProductRating() : ");
		return ratingService.addProductRating(productId, rating);
	}
	
	@PutMapping("/products/{productId}/ratings")
	public ProductRating updateProductRating(@RequestBody ProductRating productRating) {
		
		System.out.println("RatingController addProductRating() : ");
		return ratingService.updateProductRating(productRating);
	}

}
