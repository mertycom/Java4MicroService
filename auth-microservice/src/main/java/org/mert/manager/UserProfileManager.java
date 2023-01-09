package org.mert.manager;

import org.mert.dto.request.CreateProfileRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@FeignClient(
        name = "user-profile-manager",
        url = "${myapplication.user.feignurl}",
        decode404 = true
)
public interface UserProfileManager {
    @PostMapping("/create")
    ResponseEntity<Boolean> createProfile(@RequestBody @Valid CreateProfileRequestDto dto);
}
