package com.arenawebshop.aw.vat.service.vat;

import com.arenawebshop.aw.vat.presentation.dto.RsPrice;

public interface CalculationAreaSpecificService {
    RsPrice calculateVatAndCurrencyExchange(Double price, String... args);
}
