package org.mert.service;

import org.mert.repository.ProductRepository;
import org.mert.repository.entity.Product;
import org.mert.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends ServiceManager<Product,Long> {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        super(productRepository);
        this.productRepository = productRepository;
    }
}
