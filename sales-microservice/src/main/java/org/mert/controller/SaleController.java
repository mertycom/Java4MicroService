package org.mert.controller;

import lombok.RequiredArgsConstructor;
import org.mert.repository.entity.Sale;
import org.mert.service.SaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.mert.constants.RestApi.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(SALE)
public class SaleController {
    private final SaleService saleService;

    @PostMapping(GETALL)
    public ResponseEntity<List<Sale>> getAll(){
        return ResponseEntity.ok(saleService.findAll());
    }

}
