package org.mert.utility;

import com.auth0.jwt.JWT;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtTokenManager {

    public String createToken(Long id){
        String token;
        String key = "1234";
        Long exDate = 1000L*60*15;
        try {
            // Claim nesnesi olarak yerleştirdiğiniz bilgilerin açık okunur olduğunu asla unutma
            JWT.create()
                    .withAudience()
                    .withClaim("id",id)
                    .withClaim("howtopage","AuthMicroService")
                    .withClaim("isOne",true)
                    .withIssuer("java4")
                    .withIssuedAt(new Date())
                    .withExpiresAt(new Date(System.currentTimeMillis()+exDate));

        }catch (Exception e){

        }
        return null;
    }

    public Boolean validToken(String token){
        return false;
    }

    public Long getByIdFromToken(String token){
        return null;
    }
}
