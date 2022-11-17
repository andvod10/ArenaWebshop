package com.arenawebshop.aw.data.mapper;

import com.arenawebshop.aw.presentation.dto.RqPrice;
import com.beust.jcommander.JCommander;

public class PriceMapper {
    public static RqPrice toRqPrice(String... args) {
        RqPrice rqPrice = new RqPrice();
        JCommander.newBuilder()
                .addObject(rqPrice)
                .build()
                .parse(args);
        return rqPrice;
    }
}
