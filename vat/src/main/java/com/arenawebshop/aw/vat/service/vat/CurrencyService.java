package com.arenawebshop.aw.vat.service.vat;

import com.arenawebshop.aw.vat.data.entity.Currency;

public interface CurrencyService {
    public void addCurrency(Currency vat);
    public Currency getCurrency(String code);
}
