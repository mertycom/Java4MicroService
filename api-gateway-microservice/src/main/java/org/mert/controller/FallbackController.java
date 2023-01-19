package org.mert.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class FallbackController {

    @GetMapping("/fallbackauth")
    public ResponseEntity<String> fallbackAuth(){
        return ResponseEntity.ok("Servis şuan çalışmıyor. başka zaman");
    }

    @GetMapping("/fallbackproduct")
    public ResponseEntity<String> fallbackProduct(){
        return ResponseEntity.ok("Servis şuan çalışmıyor. başka zaman");
    }

    @GetMapping("/fallbacksale")
    public ResponseEntity<String> fallbackSale(){
        return ResponseEntity.ok("Servis şuan çalışmıyor. başka zaman");
    }

    @GetMapping("/fallbackuserprofile")
    public ResponseEntity<String> fallbackUserProfile(){
        return ResponseEntity.ok("Servis şuan çalışmıyor. başka zaman");
    }
}
