package com.arenawebshop.aw.presentation.dto;

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
public class RqPrice {
    @Parameter(names = {"-a", "--amount"},
            validateWith = PositiveInteger.class,
            description = "Is the amount of one product")
    @Builder.Default
    public Integer amount = 1;

    @Parameter(names = {"-p", "--price"},
            description = "Is the product cost",
            required = true)
    public Double price;

    @Parameter(names = {"--input-currency"},
            description = "Input currency")
    public String inputCurrency;

    @Parameter(names = {"--vat"},
            description = "VAT")
    public String vat;

    @Parameter(names = {"--output-currency"},
            description = "Output currency")
    public String outputCurrency ;

    @Parameter(names = {"-t", "--type"},
            description = "Is a product identifier")
    public String type;
}
