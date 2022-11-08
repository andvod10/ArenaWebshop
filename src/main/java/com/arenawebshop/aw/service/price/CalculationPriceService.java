package com.arenawebshop.aw.service.price;

import com.arenawebshop.aw.presentation.dto.RqTotalPrice;
import com.arenawebshop.aw.presentation.dto.RsTotalPrice;

public interface CalculationPriceService {
    RsTotalPrice calculateTotalPrice(RqTotalPrice rqTotalPrice);
}

