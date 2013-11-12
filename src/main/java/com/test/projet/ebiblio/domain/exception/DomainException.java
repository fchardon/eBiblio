package com.test.projet.ebiblio.domain.exception;

import java.text.MessageFormat;

public class DomainException extends RuntimeException {

    private String message;
    private Object[] datas;

    public DomainException(String message, Object... datas) {
        this.datas = datas;
        this.message = message;
    }

    public String getMessage() {
        return MessageFormat.format(message, datas);
    }
}
