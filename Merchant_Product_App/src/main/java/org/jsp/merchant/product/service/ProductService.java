package org.jsp.merchant.product.service;

import java.util.List;
import java.util.Optional;

import org.jsp.merchant.product.dao.MerchantDao;
import org.jsp.merchant.product.dao.ProductDao;
import org.jsp.merchant.product.dto.Merchant;
import org.jsp.merchant.product.dto.Product;
import org.jsp.merchant.product.dto.ResponseStructure;
import org.jsp.merchant.product.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductDao productdao;
	@Autowired
	private MerchantDao merchantdao;

	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product, int merchant_id) {
		Optional<Merchant> recMerchant = merchantdao.findById(merchant_id);
		ResponseStructure<Product> structure = new ResponseStructure<>();
		if (recMerchant.isPresent()) {
			Merchant m = recMerchant.get();
			m.getProducts().add(product); // Adding Product For Merchant
			product.setMerchant(m);// Assigning Merchant For Product
			merchantdao.updateMerchant(m);
			productdao.saveProduct(product);
			structure.setData(product);
			structure.setMessage("Product Added");
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Product>> updateProduct(Product product, int merchant_id) {
		Optional<Merchant> recMerchant = merchantdao.findById(merchant_id);
		ResponseStructure<Product> structure = new ResponseStructure<>();
		if (recMerchant.isPresent()) {
			Merchant m = recMerchant.get();
			product.setMerchant(m);
			productdao.saveProduct(product);
			structure.setData(product);
			structure.setMessage("Product Updated");
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Product>> findById(int id) {
		ResponseStructure<Product> structure = new ResponseStructure<>();
		Optional<Product> recProduct = productdao.findById(id);
		if (recProduct.isPresent()) {
			structure.setData(recProduct.get());
			structure.setMessage("Product Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<List<Product>>> findByMerchantId(int merchant_id) {
		ResponseStructure<List<Product>> structure = new ResponseStructure<>();
		Optional<Merchant> recMerchant = merchantdao.findById(merchant_id);
		if (recMerchant.isPresent()) {
			structure.setData(productdao.findByMerchantId(merchant_id));
			structure.setMessage("Product Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Product>>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
}
