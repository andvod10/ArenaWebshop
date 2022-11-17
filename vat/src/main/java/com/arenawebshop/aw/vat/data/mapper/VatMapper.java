package com.arenawebshop.aw.vat.data.mapper;

import com.arenawebshop.aw.vat.data.entity.ProductType;
import com.arenawebshop.aw.vat.data.entity.Vat;
import com.arenawebshop.aw.vat.presentation.dto.RqVat;

public class VatMapper {
    public static Vat toEntity(RqVat rqVat) {
        return Vat.builder()
                .code(rqVat.getCode())
                .rate(rqVat.getRate())
                .type(ProductType.valueOf(rqVat.getType()))
                .area(rqVat.getArea())
                .build();
    }
}
