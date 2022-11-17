package com.arenawebshop.aw.service.price;

import com.arenawebshop.aw.presentation.dto.RsPrice;

public interface CalculationPriceService {
    RsPrice calculateTotalPrice(String... args);
}

