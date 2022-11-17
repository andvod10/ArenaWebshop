package com.arenawebshop.aw.vat.service.vat;

import com.arenawebshop.aw.vat.data.entity.Currency;
import com.arenawebshop.aw.vat.data.entity.CurrencyRate;

public interface CurrencyService {
    void addCurrency(CurrencyRate vat);
    CurrencyRate getCurrency(Currency code);
    Double calculateCurrencyExchange(Currency inputCode, Currency outputCode, Double amount);
}
