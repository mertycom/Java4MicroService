package org.mert.controller;

import lombok.RequiredArgsConstructor;
import org.mert.dto.request.DoLoginRequestDto;
import org.mert.dto.request.RegisterRequestDto;
import org.mert.dto.response.DoLoginResponseDto;
import org.mert.dto.response.RegisterResponseDto;
import org.mert.repository.entity.Auth;
import org.mert.repository.entity.State;
import org.mert.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.mert.constants.RestApi.*;

@RestController
@RequestMapping(AUTH)
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping(DOLOGIN)
    public ResponseEntity<DoLoginResponseDto> doLogin(@RequestBody @Valid DoLoginRequestDto dto){

        return ResponseEntity.ok(authService.doLogin(dto));
    }

    @PostMapping(REGISTER)
    public ResponseEntity<RegisterResponseDto> register(@RequestBody @Valid RegisterRequestDto dto){

        return ResponseEntity.ok(authService.save(dto));
    }

    @GetMapping("/say")
    public ResponseEntity<String> sayHello(){

        return ResponseEntity.ok( "Selam arkadaşlar ben Auth");
    }
}
