package com.example.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.domain.Product;
import com.example.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public List<Product> getAll() {
		return productRepository.getAllBags();
	}

	public void createProduct() {
		productRepository.products.add(new Product(1, "Book1", "Books"));
		productRepository.products.add(new Product(2, "Bag1", "Bags"));
	}

	public void add(Product data) {
		productRepository.products.add(new Product(data.getId(), data.getName(), data.getCategory()));
	}

	public Product update(int id, Product data) {
		int i = getIndex(id);
		if (i != -1) {
			Product product = productRepository.products.get(i);
			product.setName(data.getName());
			product.setCategory(data.getCategory());
			return product;
		} else {
			System.out.println("No Product available with id :" + id);
		}
		return null;

	}

	public Product get(int id) {
		int i = getIndex(id);
		if (i != -1) {
			return productRepository.products.get(i);
		} else {
			System.out.println("No Product available with id :" + id);
		}
		return null;

	}

	public void delete(int id) {
		int i = getIndex(id);
		if (i != -1) {
			productRepository.products.remove(i);
		} else {
			System.out.println("No Product available with id :" + id);
		}

	}

	private int getIndex(int id) {
		int index = -1;
		int len = productRepository.products.size();

		for (int i = 0; i < len; i++) {
			if (productRepository.products.get(i).getId() == id) {
				index = i;
				System.out.println("Product available with id :" + id);
				break;
			} else {
				System.out.println("no Product available with id :" + id);
			}
		}
		return index;
	}
}
