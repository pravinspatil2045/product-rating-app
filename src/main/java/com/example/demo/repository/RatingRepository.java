package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ProductRating;

@Repository
public interface RatingRepository extends JpaRepository<ProductRating, Long> {

	List<ProductRating> findAllByProductId(int productId);

}
