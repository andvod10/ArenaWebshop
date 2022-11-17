package com.arenawebshop.aw.presentation.handler;

import com.arenawebshop.price.service.price.CalculationPriceService;
import com.arenawebshop.vat.service.vat.CalculationAreaSpecificService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalculatePriceController {
    private CalculationPriceService calculationPriceService;
    private CalculationAreaSpecificService calculationAreaSpecificService;

    @Autowired
    CalculatePriceController(CalculationPriceService calculationPriceService,
                             CalculationAreaSpecificService calculationAreaSpecificService) {
        this.calculationPriceService = calculationPriceService;
        this.calculationAreaSpecificService = calculationAreaSpecificService;
    }

    public String calculateTotalPrice(String... args) {
        double price = this.calculationPriceService.calculateTotalPrice(args).getPrice();
        return this.calculationAreaSpecificService.calculateVatAndCurrencyExchange(price, args).toString();
    }
}
