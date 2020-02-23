package com.example.product.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.product.domain.Product;

@Repository
public class ProductRepository {
	public List<Product> products = new ArrayList<Product>();

	public List<Product> getAllBags() {
		return products;
	}

}
