package com.arenawebshop.aw.presentation.handler;

import com.arenawebshop.aw.presentation.dto.RqTotalPrice;
import com.arenawebshop.aw.service.price.CalculationPriceService;
import com.beust.jcommander.JCommander;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalculatePriceController {
    private static final Logger LOG = LoggerFactory.getLogger(CalculatePriceController.class);
    private CalculationPriceService calculationPriceService;

    @Autowired
    void CalculationPrice(CalculationPriceService calculationPriceService) {
        this.calculationPriceService = calculationPriceService;
    }

    public String calculateTotalPrice(String... args) {
        RqTotalPrice rqTotalPrice = new RqTotalPrice();
        JCommander.newBuilder()
                .addObject(rqTotalPrice)
                .build()
                .parse(args);
        LOG.debug(rqTotalPrice.toString());
        return this.calculationPriceService.calculateTotalPrice(rqTotalPrice).toString();
    }
}
