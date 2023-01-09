package org.mert.controller;

import lombok.RequiredArgsConstructor;
import org.mert.dto.request.BaseRequestDto;
import org.mert.dto.request.CreateProfileRequestDto;
import org.mert.repository.entity.UserProfile;
import org.mert.service.UserProfileService;
import org.mert.utility.TokenGenerator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.util.List;

import static org.mert.constants.RestApi.*;

@RestController
@RequestMapping(USERPROFILE)
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;
    private final TokenGenerator tokenGenerator;

    @PostMapping(GETALL)
    public ResponseEntity<List<UserProfile>> userProfileList(@RequestBody @Valid BaseRequestDto dto){
        Long userid = tokenGenerator.decodeToken(dto.getToken());
        return ResponseEntity.ok(userProfileService.findAll(userid));
    }

    @PostMapping(CREATE)
    public ResponseEntity<Boolean> createProfile(@RequestBody @Valid CreateProfileRequestDto dto){
        userProfileService.save(
                UserProfile.builder()
                        .authid(dto.getAuthid())
                        .email(dto.getEmail())
                        .username(dto.getUsername())
                        .build()
        );
        return ResponseEntity.ok(true);
    }
}
