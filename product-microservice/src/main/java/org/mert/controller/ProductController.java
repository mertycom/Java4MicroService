package org.mert.controller;


import lombok.RequiredArgsConstructor;
import org.mert.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.mert.constants.RestApi.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(PRODUCT)
public class ProductController {

    private final ProductService productService;
}
