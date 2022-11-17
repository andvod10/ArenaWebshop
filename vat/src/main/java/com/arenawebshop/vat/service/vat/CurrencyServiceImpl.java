package com.arenawebshop.vat.service.vat;

import com.arenawebshop.vat.data.entity.Currency;
import com.arenawebshop.vat.data.entity.CurrencyRate;
import com.arenawebshop.vat.data.repository.CurrencyRepositoryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    private CurrencyRepositoryType currencyRepositoryType;

    @Autowired
    CurrencyServiceImpl(
            CurrencyRepositoryType currencyRepositoryType
    ) {
        this.currencyRepositoryType = currencyRepositoryType;
    }

    @Override
    public void addCurrency(CurrencyRate vat) {
        this.currencyRepositoryType.save(vat);
    }

    @Override
    public CurrencyRate getCurrency(Currency code) {
        return this.currencyRepositoryType.findByCode(code)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Couldn't find Currency by code %s", code)));
    }

    @Override
    public Double calculateCurrencyExchange(Currency inputCode, Currency outputCode, Double amount) {
        Double inputRate = this.getCurrency(inputCode).getRate();
        Double outputRate = this.getCurrency(outputCode).getRate();
        return inputRate * amount / outputRate;
    }
}
