package com.sharan.exception;

public class UserBlockedException extends Exception {
	/**
	 * Creates user object without errorDesc
	 */
	public UserBlockedException() {
		
	}
	/**
	 * Creates user object with errorDesc
	 */
	public UserBlockedException(String errDesc) {
		super(errDesc);
	}
}
