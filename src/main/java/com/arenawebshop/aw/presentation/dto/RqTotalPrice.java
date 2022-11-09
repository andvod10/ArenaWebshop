package com.arenawebshop.aw.presentation.dto;

import com.arenawebshop.aw.data.entity.Currency;
import com.arenawebshop.aw.data.entity.ProductType;
import com.arenawebshop.aw.data.mapper.CurrencyConverter;
import com.arenawebshop.aw.data.mapper.ProductTypeConverter;
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
public class RqTotalPrice {
    @Parameter(names = {"-a", "--amount"},
            validateWith = PositiveInteger.class,
            description = "Is the amount of one product")
    @Builder.Default
    public Integer amount = 1;

    @Parameter(names = {"-p", "--price"},
            description = "Is the product cost in used currency",
            required = true)
    public Double price;

    @Parameter(names = {"-t", "--type"},
            description = "Is a product identifier",
            converter = ProductTypeConverter.class)
    @Builder.Default
    public ProductType type = ProductType.BOOK;

    @Parameter(names = {"--input-currency"},
            converter = CurrencyConverter.class,
            description = "Input currency")
    @Builder.Default
    public Currency inputCurrency = Currency.DKK;

    @Parameter(names = {"--vat"},
            description = "VAT",
            required = true)
    public String vat;

    @Parameter(names = {"--output-currency"},
            converter = CurrencyConverter.class,
            description = "Output currency")
    @Builder.Default
    public Currency outputCurrency = Currency.DKK;
}
