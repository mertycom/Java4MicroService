package org.mert.service;

import org.mert.dto.request.CreateProfileRequestDto;
import org.mert.dto.request.DoLoginRequestDto;
import org.mert.dto.request.RegisterRequestDto;
import org.mert.dto.response.RegisterResponseDto;
import org.mert.exception.AuthMicroserviceExecption;
import org.mert.exception.ErrorType;
import org.mert.manager.UserProfileManager;
import org.mert.mapper.AuthMapper;
import org.mert.repository.AuthRepository;
import org.mert.repository.entity.Auth;
import org.mert.utility.ServiceManager;
import org.mert.utility.TokenGenerator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService extends ServiceManager<Auth,Long> {

    private final AuthRepository authRepository;
    private final UserProfileManager userProfileManager;
    private final TokenGenerator tokenGenerator;

    public AuthService(AuthRepository authRepository, UserProfileManager userProfileManager, TokenGenerator tokenGenerator) {
        super(authRepository);
        this.authRepository = authRepository;
        this.userProfileManager = userProfileManager;
        this.tokenGenerator = tokenGenerator;
    }

    public RegisterResponseDto save(RegisterRequestDto dto){
        /**
         * Eğer şifre ile ikinci şifre uyuşmuyor ise, direkt false
         * dönülmesi mantıklıdır.
         */
        if(!dto.getPassword().equals(dto.getRepassword()))
            throw new AuthMicroserviceExecption(ErrorType.REGISTER_REPASSWORD_ERROR);

        /**
         * Burada elle dönüşüm yerine Mapper kullanmak daha
         * doğru olacaktır.
         */
    /* Elle dönüşüm işlemi
    save(
            Auth.builder()
                    .email(dto.getEmail())
                    .username(dto.getUsername())
                    .password(dto.getPassword())
                    .build()
    );
     */ if(authRepository.findOptionalByUsername(dto.getUsername()).isPresent())
            throw new AuthMicroserviceExecption(ErrorType.REGISTER_KULLANICIADI_KAYITLI);
        Auth auth = save(AuthMapper.INSTANCE.fromRegisterRequestDto(dto));
        userProfileManager.createProfile(
                CreateProfileRequestDto.builder()
                        .token("")
                        .authid(auth.getId())
                        .username(auth.getUsername())
                        .email(auth.getEmail())
                        .build()
        );
        RegisterResponseDto result = AuthMapper.INSTANCE.fromAuth(auth);
        result.setRegisterstate(100);
        result.setContent(auth.getEmail()+" ile başarı şekilde kayıt oldunuz.");
        return  result;
    }

    public String doLogin(DoLoginRequestDto dto){

        Optional<Auth> auth = authRepository.findOptionalByUsernameAndPassword(
                dto.getUsername(),
                dto.getPassword()
        );
        if (auth.isEmpty())
            throw new AuthMicroserviceExecption(ErrorType.LOGIN_ERROR);
        return tokenGenerator.createToken(auth.get().getId());
    }

}
