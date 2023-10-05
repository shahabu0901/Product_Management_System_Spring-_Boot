package org.jsp.merchant.product.repository;

import java.util.Optional;

import org.jsp.merchant.product.dto.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MerchantRepository extends JpaRepository<Merchant, Integer> {

	@Query("select m from Merchant m where m.phone=?1 and m.password=?2")
	Optional<Merchant> VerifyMerchant(long phone, String password);

	@Query("select m from Merchant m where m.email=?1 and m.password=?2")
	Optional<Merchant> VerifyByEmailAndPassword(String email, String password);

	@Query("select m from Merchant m where m.name=?1 and m.phone=?2")
	Optional<Merchant> VerifyByNameAndPhone(String name, long phone);
}
