package com.arenawebshop.aw.vat.presentation.controller;

import com.arenawebshop.aw.vat.data.mapper.CurrencyMapper;
import com.arenawebshop.aw.vat.presentation.dto.RqCurrency;
import com.arenawebshop.aw.vat.service.vat.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/currency")
public class CurrencyController {
    private CurrencyService currencyService;

    @Autowired
    CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @PostMapping()
    void addVat(@RequestBody RqCurrency rqCurrency) {
        this.currencyService.addCurrency(CurrencyMapper.toEntity(rqCurrency));
    }
}
