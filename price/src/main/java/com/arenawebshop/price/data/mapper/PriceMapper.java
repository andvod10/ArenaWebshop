package com.arenawebshop.price.data.mapper;

import com.arenawebshop.price.presentation.dto.RqPrice;
import com.beust.jcommander.JCommander;

public class PriceMapper {
    public static RqPrice toRqPrice(String... args) {
        RqPrice rqPrice = new RqPrice();
        JCommander.newBuilder()
                .addObject(rqPrice)
                .acceptUnknownOptions(true)
                .build()
                .parse(args);
        return rqPrice;
    }
}
