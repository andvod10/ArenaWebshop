package com.arenawebshop.price.service.price;

import com.arenawebshop.price.presentation.dto.RsPrice;

public interface CalculationPriceService {
    RsPrice calculateTotalPrice(String... args);
}

