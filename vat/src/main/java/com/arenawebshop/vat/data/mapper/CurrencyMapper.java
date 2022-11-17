package com.arenawebshop.vat.data.mapper;

import com.arenawebshop.vat.data.entity.Currency;
import com.arenawebshop.vat.data.entity.CurrencyRate;
import com.arenawebshop.vat.presentation.dto.RqCurrency;

public class CurrencyMapper {
    public static CurrencyRate toEntity(RqCurrency rqVat) {
        return CurrencyRate.builder()
                .code(Currency.valueOf(rqVat.getCode()))
                .rate(rqVat.getRate())
                .build();
    }
}
