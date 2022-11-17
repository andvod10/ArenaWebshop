package com.arenawebshop.aw.presentation.handler;

import com.arenawebshop.aw.service.price.CalculationPriceService;
import com.arenawebshop.aw.vat.service.vat.CalculationAreaSpecificServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalculatePriceController {
    private CalculationPriceService calculationPriceService;
    private CalculationAreaSpecificServiceImpl calculationAreaSpecificService;

    @Autowired
    CalculatePriceController(CalculationPriceService calculationPriceService,
                             CalculationAreaSpecificServiceImpl calculationAreaSpecificService) {
        this.calculationPriceService = calculationPriceService;
        this.calculationAreaSpecificService = calculationAreaSpecificService;
    }

    public String calculateTotalPrice(String... args) {
        double price = this.calculationPriceService.calculateTotalPrice(args).getPrice();
        return this.calculationAreaSpecificService.calculateVatAndCurrencyExchange(price, args).toString();
    }
}
