package com.arenawebshop.aw.presentation.dto;

import com.arenawebshop.aw.data.entity.Currency;
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
public class RsTotalPrice {
    private Double totalPrice;
    @Builder.Default
    private Currency currency = Currency.DKK;
}
