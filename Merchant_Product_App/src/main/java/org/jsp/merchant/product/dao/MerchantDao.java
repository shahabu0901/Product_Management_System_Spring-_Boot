package org.jsp.merchant.product.dao;

import java.util.Optional;

import org.jsp.merchant.product.dto.Merchant;
import org.jsp.merchant.product.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MerchantDao {
	@Autowired
	private MerchantRepository repository;

	public Merchant saveMerchant(Merchant merchant) {
		System.out.println(repository);
		return repository.save(merchant);
	}

	public Merchant updateMerchant(Merchant merchant) {
		return repository.save(merchant);
	}

	public Optional<Merchant> findById(int id) {
		return repository.findById(id);
	}

	public boolean deleteById(int id) {
		Optional<Merchant> recMerchant = findById(id);
		if (recMerchant.isPresent()) {
			// repository.delete(recMerchant.get()); Optional
			repository.deleteById(id);
			return true;
		}
		return false;
	}

	public Optional<Merchant> VerifyMerchant(long phone, String password) {
		return repository.VerifyMerchant(phone, password);
	}

	public Optional<Merchant> VerifyByEmail(String email, String password) {
		return repository.VerifyByEmailAndPassword(email, password);
	}

	public Optional<Merchant> VerifyByName(String name, long phone) {
		return repository.VerifyByNameAndPhone(name, phone);
	}
}
