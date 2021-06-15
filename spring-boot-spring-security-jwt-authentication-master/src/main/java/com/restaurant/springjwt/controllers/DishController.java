package com.restaurant.springjwt.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.restaurant.springjwt.dishService.DishDaoService;
import com.restaurant.springjwt.models.Dish;



@RestController
@RequestMapping("/api")
@CrossOrigin
public class DishController {
	
	
	@Autowired
	DishDaoService productService;
		
	
	@GetMapping("/products")
	public List<Dish> retrieveProducts() {
		return productService.getDish();
	}
	
	@GetMapping(value = "/downloadFile/{fileName:.+}")
    public ResponseEntity<org.springframework.core.io.Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        return productService.showImage(fileName, request);
    }
	
	@GetMapping("/products/{productId}")
	public Dish retrieveProduct(@PathVariable Long productId) {
		return productService.getDish(productId);
	}
	
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<Object> deleteProduct(@PathVariable Long productId) {
		return productService.removeDish(productId);
	}
	
	@PostMapping("/products")
	public ResponseEntity<Object> createCategory( @RequestParam String name, @RequestParam int quantity,
			@RequestParam String price, @RequestPart MultipartFile pxtImage) {
		
		return productService.postDish(name, quantity, price, pxtImage);
		
	}
	
//	@PutMapping("/products/{productId}")
//	public ResponseEntity<Object> updateCategory(@PathVariable int productId, @RequestParam String name, 
//			@RequestParam int quantity, @RequestParam String price, @RequestPart MultipartFile pxtImage) {
//		
//		return productService.editProduct(productId, name, quantity, price, pxtImage);
//		
//	}	
	
	
	

}
