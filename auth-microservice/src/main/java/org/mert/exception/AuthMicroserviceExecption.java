package org.mert.exception;

import lombok.Getter;

@Getter
public class AuthMicroserviceExecption extends RuntimeException{

    private final ErrorType errorType;

    public AuthMicroserviceExecption(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public AuthMicroserviceExecption(ErrorType errorType,String message) {
        super(message);
        this.errorType = errorType;
    }

}
