package org.mert.controller;

import lombok.RequiredArgsConstructor;
import org.mert.dto.request.DoLoginRequestDto;
import org.mert.dto.request.RegisterRequestDto;
import org.mert.dto.response.RegisterResponseDto;
import org.mert.repository.entity.Auth;
import org.mert.repository.entity.State;
import org.mert.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.mert.constants.RestApi.*;

@RestController
@RequestMapping(AUTH)
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping(DOLOGIN)
    public ResponseEntity<String> doLogin(@RequestBody @Valid DoLoginRequestDto dto){

        return ResponseEntity.ok(authService.doLogin(dto));
    }

    @PostMapping(REGISTER)
    public ResponseEntity<RegisterResponseDto> register(@RequestBody @Valid RegisterRequestDto dto){

        return ResponseEntity.ok(authService.save(dto));
    }
}
