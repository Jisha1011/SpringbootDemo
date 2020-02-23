package com.example.product.transformer;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.example.product.domain.Product;

@Component
public class ProductTransformer {
	public JSONObject transform(Product product) {
		JSONObject jObj = new JSONObject();
		jObj.put("productId", product.getId());
		jObj.put("productName", product.getName());
		jObj.put("productCategory", product.getCategory());
		return jObj;

	}
	/*
	 * public Object transformAll(List<Product> product) { JSONObject jObj = new
	 * JSONObject();
	 * 
	 * jObj.put("productId", product.getId()); jObj.put("productId",
	 * product.getName());
	 * 
	 * Map<String, JSONObject> map = new HashMap<>(); map.put(p, arg1)
	 * 
	 * return product;
	 * 
	 * }
	 */
}
