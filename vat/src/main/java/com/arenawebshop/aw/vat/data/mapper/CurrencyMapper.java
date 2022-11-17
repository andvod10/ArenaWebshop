package com.arenawebshop.aw.vat.data.mapper;

import com.arenawebshop.aw.vat.data.entity.Currency;
import com.arenawebshop.aw.vat.data.entity.CurrencyRate;
import com.arenawebshop.aw.vat.presentation.dto.RqCurrency;

public class CurrencyMapper {
    public static CurrencyRate toEntity(RqCurrency rqVat) {
        return CurrencyRate.builder()
                .code(Currency.valueOf(rqVat.getCode()))
                .rate(rqVat.getRate())
                .build();
    }
}
