package com.project.swagger.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.swagger.Entity.Product;
import com.project.swagger.Service.Product_Sv;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/products")
public class Product_Controller {
	@Autowired
	private Product_Sv productService;

	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id) {
		Product product = productService.getProductById(id);
		return ResponseEntity.ok(product);
	}

	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		Product createdProduct = productService.createProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product productDetails) {
		Product updatedProduct = productService.updateProduct(id, productDetails);
		return ResponseEntity.ok(updatedProduct);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
		productService.deleteProduct(id);
		return ResponseEntity.noContent().build();
	}
}
