package com.arenawebshop.aw.vat.data.mapper;

import com.arenawebshop.aw.vat.presentation.dto.RqCalculationParams;
import com.beust.jcommander.JCommander;

public class CalculationParamsMapper {
    public static RqCalculationParams toRqCalculationParams(String... args) {
        RqCalculationParams rqCalculationParams = new RqCalculationParams();
        JCommander.newBuilder()
                .addObject(rqCalculationParams)
                .build()
                .parse(args);
        return rqCalculationParams;
    }
}
