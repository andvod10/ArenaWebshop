package com.arenawebshop.aw.vat.data.mapper;

import com.arenawebshop.aw.vat.data.entity.Currency;
import com.arenawebshop.aw.vat.presentation.dto.RqCurrency;

public class CurrencyMapper {
    public static Currency toEntity(RqCurrency rqVat) {
        return Currency.builder()
                .code(rqVat.getCode())
                .rate(rqVat.getRate())
                .build();
    }
}
