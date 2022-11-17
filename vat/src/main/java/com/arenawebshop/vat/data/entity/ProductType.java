package com.arenawebshop.vat.data.entity;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public enum ProductType {
    BOOK,
    ONLINE;

    public static ProductType getProductType(String productType) {
        Optional<ProductType> found = Arrays.stream(ProductType.values())
                .filter(type -> productType.equalsIgnoreCase(type.toString()))
                .findFirst();
        String enumValues = Arrays.stream(ProductType.values())
                .map(Enum::name)
                .collect(Collectors.joining(", "));
        return found.orElseThrow(() -> new IllegalArgumentException(String
                .format("Value %s doesn't available for ProductType. Choose one of %s", productType, enumValues)));
    }
}
