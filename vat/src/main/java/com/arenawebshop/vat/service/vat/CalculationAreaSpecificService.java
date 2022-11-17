package com.arenawebshop.vat.service.vat;

import com.arenawebshop.vat.presentation.dto.RsPrice;

public interface CalculationAreaSpecificService {
    RsPrice calculateVatAndCurrencyExchange(Double price, String... args);
}
