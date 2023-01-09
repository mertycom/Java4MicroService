package org.mert.service;

import org.mert.repository.SaleRepository;
import org.mert.repository.entity.Sale;
import org.mert.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class SaleService extends ServiceManager<Sale,Long> {
    private final SaleRepository salesRepository;

    public SaleService(SaleRepository salesRepository) {
        super(salesRepository);
        this.salesRepository = salesRepository;
    }
}
