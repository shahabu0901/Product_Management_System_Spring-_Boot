
package org.jsp.merchant.product.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.merchant.product.dto.Product;
import org.jsp.merchant.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {
	@Autowired
	private ProductRepository repository;

	public Product saveProduct(Product product) {
		return repository.save(product);
	}

	public Product updateProduct(Product product) {
		return repository.save(product);
	}

	public Optional<Product> findById(int id) {
		return repository.findById(id);
	}

	public List<Product> findByMerchantId(int merchant_id) {
		return repository.findByMerchantId(merchant_id);
	}
}
