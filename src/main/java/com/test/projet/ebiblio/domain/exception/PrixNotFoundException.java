package com.test.projet.ebiblio.domain.exception;

public class PrixNotFoundException extends DomainException {

	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 6339327856653891055L;

	public PrixNotFoundException(String message, Object... datas) {
	        super(message, datas);
	    }
}
