package com.arenawebshop.vat.presentation.dto;

import com.arenawebshop.vat.data.converter.CurrencyConverter;
import com.arenawebshop.vat.data.converter.ProductTypeConverter;
import com.arenawebshop.vat.data.entity.Currency;
import com.arenawebshop.vat.data.entity.ProductType;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.validators.PositiveInteger;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RqCalculationParams {
    @Parameter(names = {"--input-currency"},
            description = "Input currency",
            converter = CurrencyConverter.class)
    @Builder.Default
    public Currency inputCurrency = Currency.DKK;

    @Parameter(names = {"--vat"},
            description = "VAT",
            required = true)
    public String vat;

    @Parameter(names = {"--output-currency"},
            description = "Output currency",
            converter = CurrencyConverter.class)
    @Builder.Default
    public Currency outputCurrency = Currency.DKK;

    @Parameter(names = {"-t", "--type"},
            description = "Is a product identifier",
            converter = ProductTypeConverter.class)
    @Builder.Default
    public ProductType type = ProductType.BOOK;
}
