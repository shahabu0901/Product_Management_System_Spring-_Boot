package org.jsp.merchant.product.exception;

@SuppressWarnings("serial")
public class IdNotFoundException extends RuntimeException {
	@Override
	public String getMessage() {
		return "Invalid Merchants Id ";
	}
}
