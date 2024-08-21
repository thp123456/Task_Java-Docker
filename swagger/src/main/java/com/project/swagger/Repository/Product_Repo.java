package com.project.swagger.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.swagger.Entity.Product;

@Repository
public interface Product_Repo extends JpaRepository<Product, Integer> {

}
