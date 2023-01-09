package org.mert.exception;

import lombok.Getter;

@Getter
public class ProductMicroserviceExecption extends RuntimeException{

    private final ErrorType errorType;

    public ProductMicroserviceExecption(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public ProductMicroserviceExecption(ErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }

}
