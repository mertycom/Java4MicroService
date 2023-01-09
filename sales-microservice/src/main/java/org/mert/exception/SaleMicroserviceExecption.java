package org.mert.exception;

import lombok.Getter;

@Getter
public class SaleMicroserviceExecption extends RuntimeException{

    private final ErrorType errorType;

    public SaleMicroserviceExecption(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public SaleMicroserviceExecption(ErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }

}
