package com.arenawebshop.price.presentation.dto;

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
}
