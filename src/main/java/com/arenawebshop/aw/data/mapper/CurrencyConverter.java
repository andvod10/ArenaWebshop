package com.arenawebshop.aw.data.mapper;

import com.arenawebshop.aw.data.entity.Currency;
import com.beust.jcommander.IStringConverter;

public class CurrencyConverter implements IStringConverter<Currency> {
    @Override
    public Currency convert(String value) {
        return Currency.getCurrency(value);
    }
}
