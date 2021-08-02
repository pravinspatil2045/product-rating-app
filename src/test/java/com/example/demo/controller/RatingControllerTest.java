package com.example.demo.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.model.Product;
import com.example.demo.service.RatingService;


@RunWith(SpringRunner.class)
@WebMvcTest(RatingController.class)
public class RatingControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RatingService ratingService;
	
	@Test
	public void getProductRating_ShouldReturnProductRating() throws Exception {
		
		given(ratingService.getProductRating(1)).willReturn(new Product(1, 9.0, 1));

		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products/1/ratings")).andExpect(status().isOk())
				.andExpect(jsonPath("rating").value("9.0")).andExpect(jsonPath("productId").value("1"));

	}

}
