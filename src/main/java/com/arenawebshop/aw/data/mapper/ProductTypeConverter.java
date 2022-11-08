package com.arenawebshop.aw.data.mapper;

import com.arenawebshop.aw.data.entity.ProductType;
import com.beust.jcommander.IStringConverter;

public class ProductTypeConverter implements IStringConverter<ProductType> {
    @Override
    public ProductType convert(String value) {
        return ProductType.getProductType(value);
    }
}
