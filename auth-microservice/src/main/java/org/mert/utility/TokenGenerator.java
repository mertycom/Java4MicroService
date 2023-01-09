package org.mert.utility;

import org.mert.exception.AuthMicroserviceExecption;
import org.mert.exception.ErrorType;
import org.springframework.stereotype.Component;

@Component
public class TokenGenerator {
    public String createToken(Long userid){
        return "Brr:"+userid;
    }

    public String decodeToken(String token){
        try {
            return token.split(":")[1];
        }catch (Exception e){
            throw  new AuthMicroserviceExecption(ErrorType.INTERNAL_ERROR);
        }
    }
}
