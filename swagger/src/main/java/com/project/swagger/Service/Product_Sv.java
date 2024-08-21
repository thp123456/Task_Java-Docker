package com.project.swagger.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.swagger.Entity.Product;
import com.project.swagger.Repository.Product_Repo;

@Service
public class Product_Sv {
	@Autowired
	private Product_Repo productRepository;

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product getProductById(int id) {
		return productRepository.findById(id).orElseThrow();
	}

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	public Product updateProduct(int id, Product productDetails) {
		Product product = productRepository.findById(id).orElseThrow();

		product.setCode(productDetails.getCode());
		product.setName(productDetails.getName());
		product.setCategory(productDetails.getCategory());
		product.setBrand(productDetails.getBrand());
		product.setType(productDetails.getType());
		product.setDescription(productDetails.getDescription());
		product.setCreated_at(productDetails.getCreated_at());
		product.setUpdated_at(productDetails.getUpdated_at());

		return productRepository.save(product);
	}

	public void deleteProduct(int id) {
		Product product = productRepository.findById(id).orElseThrow();

		productRepository.delete(product);
	}
}
