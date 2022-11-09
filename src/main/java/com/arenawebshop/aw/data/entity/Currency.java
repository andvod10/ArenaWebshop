package com.arenawebshop.aw.data.entity;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public enum Currency {
    DKK,
    NOK,
    SEK,
    GBP,
    EUR;

    public static Currency getCurrency(String currency) {
        Optional<Currency> found = Arrays.stream(Currency.values())
                .filter(type -> currency.equalsIgnoreCase(type.toString()))
                .findFirst();
        String enumValues = Arrays.stream(Currency.values())
                .map(Enum::name)
                .collect(Collectors.joining(", "));
        return found.orElseThrow(() -> new IllegalArgumentException(String
                .format("Value %s doesn't available for Currency. Choose one of %s", currency, enumValues)));
    }
}
