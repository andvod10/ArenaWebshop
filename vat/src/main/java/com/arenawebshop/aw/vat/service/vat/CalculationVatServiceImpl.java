package com.arenawebshop.aw.vat.service.vat;

import com.arenawebshop.aw.vat.data.repository.CurrencyRepository;
import com.arenawebshop.aw.vat.data.repository.VatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculationVatServiceImpl implements CalculationVatService {
    private CurrencyService currencyService;
    private VatService vatService;

    @Autowired
    CalculationVatServiceImpl(
            CurrencyService currencyService,
            VatService vatService
    ) {
        this.currencyService = currencyService;
        this.vatService = vatService;
    }

    @Override
    public Double calculateVat(String code, String type) {
        return this.vatService.getVat(code, type).getRate();
    }

    @Override
    public Double calculateCurrencyExchange(String inputCode, String outputCode, Double amount) {
        Double inputRate = this.currencyService.getCurrency(inputCode).getRate();
        Double outputRate = this.currencyService.getCurrency(outputCode).getRate();
        return inputRate * amount / outputRate;
    }
}
