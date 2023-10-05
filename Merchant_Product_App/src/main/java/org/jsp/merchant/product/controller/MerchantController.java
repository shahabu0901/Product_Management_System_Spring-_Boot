package org.jsp.merchant.product.controller;

import org.jsp.merchant.product.dto.Merchant;
import org.jsp.merchant.product.dto.ResponseStructure;
import org.jsp.merchant.product.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MerchantController {
	@Autowired
	private MerchantService service;

	@PostMapping("/merchants")
	public ResponseEntity<ResponseStructure<Merchant>> saveMerchant(@RequestBody Merchant merchant) {

		return service.saveMerchant(merchant);
	}

	@PutMapping("/merchants")
	public ResponseEntity<ResponseStructure<Merchant>> updateMerchant(@RequestBody Merchant merchant) {
		return service.updateMerchant(merchant);
	}

	@GetMapping("/merchants/{id}")
	public ResponseEntity<ResponseStructure<Merchant>> findById(@PathVariable int id) {
		return service.findById(id);
	}

	@DeleteMapping("/merchants/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}

	@PostMapping("/merchants/verify-by-phone") // Verify By Phone and Password
	public ResponseEntity<ResponseStructure<Merchant>> verifyMerchant(@RequestParam long phone,
			@RequestParam String password) {
		return service.verifyMerchant(phone, password);
	}

	@PostMapping("/merchants/verify-by-email") // Verify By Email and password
	public ResponseEntity<ResponseStructure<Merchant>> VerifyByEmail(@RequestParam String email,
			@RequestParam String password) {
		return service.VerifyByEmail(email, password);
	}

	@PostMapping("/merchants/verify-by-name")
	public ResponseEntity<ResponseStructure<Merchant>> VerifyByName(@RequestParam String name,
			@RequestParam long phone) {
		return service.VerifyByName(name, phone);
	}

}
