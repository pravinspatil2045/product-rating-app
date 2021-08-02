package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.model.ProductRating;
import com.example.demo.repository.RatingRepository;

@Service
public class RatingService {

	@Autowired
	RatingRepository ratingRepository;

	public Product getProductRating(int productId) {

		System.out.println("RatingService getProductRating() : ");

		List<ProductRating> list = ratingRepository.findAllByProductId(productId);
		
		Product product = new Product();
		product.setProductId(productId);

		int size = list.size();
		product.setCount(size);

		if (size != 0) {
			int sum = 0;
			for (ProductRating rating : list) {
				sum += rating.getRating();
			}
			product.setRating(sum / size);
		} else {
			product.setRating(0);
		}

		return product;
	}

	public ProductRating addProductRating(int productId, int rating) {

		System.out.println("RatingService addProductRating() : ");

		ProductRating pr = new ProductRating();
		pr.setProductId(productId);
		pr.setRating(rating);

		return ratingRepository.save(pr);
	}

	public ProductRating updateProductRating(ProductRating productRating) {
		
		System.out.println("RatingService updateProductRating() : ");
		
		Optional<ProductRating> optional = ratingRepository.findById(productRating.getId());
		ProductRating newProductRating = optional.get();
		if(newProductRating != null) {
			newProductRating.setRating(productRating.getRating());
			return ratingRepository.save(newProductRating);
		}
		return null;
	}

}
