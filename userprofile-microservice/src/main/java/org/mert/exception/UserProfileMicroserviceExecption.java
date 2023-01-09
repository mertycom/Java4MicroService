package org.mert.exception;

import lombok.Getter;

@Getter
public class UserProfileMicroserviceExecption extends RuntimeException{

    private final ErrorType errorType;

    public UserProfileMicroserviceExecption(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public UserProfileMicroserviceExecption(ErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }

}
