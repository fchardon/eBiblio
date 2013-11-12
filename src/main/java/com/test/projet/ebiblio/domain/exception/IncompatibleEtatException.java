package com.test.projet.ebiblio.domain.exception;

public class IncompatibleEtatException extends DomainException {

    /**
     * 
     */
    private static final long serialVersionUID = 2012995806082837582L;

    public IncompatibleEtatException(String message, Object... datas) {
        super(message, datas);
    }

}