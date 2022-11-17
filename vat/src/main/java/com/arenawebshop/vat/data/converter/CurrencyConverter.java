package com.arenawebshop.vat.data.converter;

import com.arenawebshop.vat.data.entity.Currency;
import com.beust.jcommander.IStringConverter;

public class CurrencyConverter implements IStringConverter<Currency> {
    @Override
    public Currency convert(String value) {
        return Currency.getCurrency(value);
    }
}
