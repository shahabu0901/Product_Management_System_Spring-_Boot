package org.jsp.merchant.product.controller;

import java.util.List;

import org.jsp.merchant.product.dto.Product;
import org.jsp.merchant.product.dto.ResponseStructure;
import org.jsp.merchant.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ProductController {
	@Autowired
	private ProductService pservice;

	@PostMapping("/products/{merchant_id}")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product,
			@PathVariable int merchant_id) {
		return pservice.saveProduct(product, merchant_id);
	}

	@PutMapping("/products/{merchant_id}")
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product,
			@PathVariable int merchant_id) {
		return pservice.saveProduct(product, merchant_id);
	}

	@GetMapping("/products/by-id/{id}")
	public ResponseEntity<ResponseStructure<Product>> findsById(@PathVariable int id) {
		return pservice.findById(id);
	}

	
	@GetMapping("/products/{merchant_id}")
	public ResponseEntity<ResponseStructure<List<Product>>> findByMerchantId(@PathVariable int merchant_id) {
		return pservice.findByMerchantId(merchant_id);
	}

}
