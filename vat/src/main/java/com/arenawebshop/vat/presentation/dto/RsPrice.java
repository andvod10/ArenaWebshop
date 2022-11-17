package com.arenawebshop.vat.presentation.dto;

import com.arenawebshop.vat.data.entity.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@AllArgsConstructor
@ToString(includeFieldNames = false)
public class RsPrice {
    private Double price;
    @Builder.Default
    private Currency currency = Currency.DKK;
}
