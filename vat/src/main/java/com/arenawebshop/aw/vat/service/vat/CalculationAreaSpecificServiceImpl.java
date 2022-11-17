package com.arenawebshop.aw.vat.service.vat;

import com.arenawebshop.aw.vat.data.mapper.CalculationParamsMapper;
import com.arenawebshop.aw.vat.presentation.dto.RqCalculationParams;
import com.arenawebshop.aw.vat.presentation.dto.RsPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.ParseException;

@Service
public class CalculationAreaSpecificServiceImpl implements CalculationAreaSpecificService {
    private CurrencyService currencyService;
    private VatService vatService;

    @Autowired
    CalculationAreaSpecificServiceImpl(
            CurrencyService currencyService,
            VatService vatService
    ) {
        this.currencyService = currencyService;
        this.vatService = vatService;
    }

    @Override
    public RsPrice calculateVatAndCurrencyExchange(Double price, String... args) {
        RqCalculationParams rqCalculationParams = CalculationParamsMapper.toRqCalculationParams(args);
        double vatRate = this.vatService.calculateVat(rqCalculationParams.vat, rqCalculationParams.type);
        double exchangedMoney = this.currencyService.calculateCurrencyExchange(
                rqCalculationParams.inputCurrency,
                rqCalculationParams.outputCurrency,
                price);
        return RsPrice.builder()
                .price(round(exchangedMoney + exchangedMoney * vatRate / 100))
                .currency(rqCalculationParams.outputCurrency)
                .build();
    }

    private Double round(double value) {
        DecimalFormat df = new DecimalFormat("0.00");
        String format = df.format(value);
        try {
            return (Double) df.parse(format);
        } catch (ParseException ex) {
            throw new IllegalArgumentException(String
                    .format("Value %f couldn't be rounded", value));
        }
    }
}
