package com.arenawebshop.vat.data.converter;

import com.arenawebshop.vat.data.entity.ProductType;
import com.beust.jcommander.IStringConverter;

public class ProductTypeConverter implements IStringConverter<ProductType> {
    @Override
    public ProductType convert(String value) {
        return ProductType.getProductType(value);
    }
}
