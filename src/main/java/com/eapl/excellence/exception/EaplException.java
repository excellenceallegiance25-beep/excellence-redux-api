package com.eapl.excellence.exception;

public class EaplException extends RuntimeException {

	public EaplException(final String errorMessage, final String errorCode) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public EaplException(final String errorMessage, final String errorCode, final Throwable throwable) {
		super(errorMessage, throwable);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	private static final long serialVersionUID = 98798237498231L;
	private final String errorCode;
	private final String errorMessage;

	@Override
	public String toString() {
		return "EaplException [errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
	}

}
