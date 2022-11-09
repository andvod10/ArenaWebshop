package com.arenawebshop.aw.vat.service.vat;

import com.arenawebshop.aw.vat.data.entity.Currency;
import com.arenawebshop.aw.vat.data.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    private CurrencyRepository currencyRepository;

    @Autowired
    CurrencyServiceImpl(
            CurrencyRepository currencyRepository
    ) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public void addCurrency(Currency vat) {
        this.currencyRepository.save(vat);
    }

    @Override
    public Currency getCurrency(String code) {
        return this.currencyRepository.findByCodeIgnoreCase(code)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Couldn't find Currency by code %s", code)));
    }
}
