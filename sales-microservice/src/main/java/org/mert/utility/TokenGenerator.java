package org.mert.utility;

import org.mert.exception.ErrorType;
import org.mert.exception.UserProfileMicroserviceExecption;
import org.springframework.stereotype.Component;

@Component
public class TokenGenerator {
    public String createToken(Long userid){
        return "Brr:"+userid;
    }

    public Long decodeToken(String token){
        try{
            if(!token.split(":")[0].equals("Brr"))
                throw  new UserProfileMicroserviceExecption(ErrorType.INVALID_TOKEN);
            String userid = token.split(":")[1]; //rwerwer16  --  Brr:16 -> [Brr,16]
            return Long.parseLong(userid);
        }catch (Exception e){
            throw new UserProfileMicroserviceExecption(ErrorType.INVALID_TOKEN);
        }
    }

}
