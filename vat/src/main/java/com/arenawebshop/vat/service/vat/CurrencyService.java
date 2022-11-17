package com.arenawebshop.vat.service.vat;

import com.arenawebshop.vat.data.entity.Currency;
import com.arenawebshop.vat.data.entity.CurrencyRate;

public interface CurrencyService {
    void addCurrency(CurrencyRate vat);
    CurrencyRate getCurrency(Currency code);
    Double calculateCurrencyExchange(Currency inputCode, Currency outputCode, Double amount);
}
