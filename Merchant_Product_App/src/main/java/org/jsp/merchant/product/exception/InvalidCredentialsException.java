package org.jsp.merchant.product.exception;

@SuppressWarnings("serial")
public class InvalidCredentialsException extends RuntimeException {
	@Override
	public String getMessage() {
		return " Invalid Credentials Id or Phone or Email or Password ";
	}

}
