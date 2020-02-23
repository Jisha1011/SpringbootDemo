package com.example.product.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.domain.Product;
import com.example.product.service.ProductService;
import com.example.product.transformer.ProductTransformer;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	ProductTransformer productTransformer;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Product> getAll() {
		return productService.getAll();
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public void add(@RequestBody Product data) {
		productService.add(data);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable int id, @RequestBody Product data) {
		productService.update(id, data);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Product get(@PathVariable int id) {
		return productService.get(id);
		// return productTransformer.transform(productService.get(id));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable int id) {
		productService.delete(id);
	}

	@PostConstruct
	private void addDefaultData() {
		productService.createProduct();
	}

}
