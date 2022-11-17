package com.arenawebshop.aw.presentation.handler.dto;

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
public class RqPrices {
    @Parameter(names = {"-a", "--amount"},
            validateWith = PositiveInteger.class,
            description = "Is the amount of one product")
    @Builder.Default
    public Integer amount = 1;

    @Parameter(names = {"-p", "--price"},
            description = "Is the product cost",
            required = true)
    public Double price;
}
