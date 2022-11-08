package com.arenawebshop.aw;

import com.arenawebshop.aw.presentation.handler.CalculatePriceController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
public class ExecCommandLineRunner implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory.getLogger(AwApplication.class);

    private CalculatePriceController calculatePriceController;

    @Autowired
    void CalculationPrice(CalculatePriceController calculatePriceController) {
        this.calculatePriceController = calculatePriceController;
    }

    @Override
    public void run(String... args) {
        LOG.debug("Params provided: {}", String.join(",", args));

        // When web will be integrated to the app, can be used ControllerAdvice for exception handling
        try {
            LOG.info(calculatePriceController.calculateTotalPrice(args));
        } catch (Exception ex) {
            LOG.error("Unexpected error appeared: {}", ex.getLocalizedMessage());
        }
    }
}
