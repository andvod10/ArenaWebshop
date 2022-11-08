package com.arenawebshop.aw.vat.service.vat;

public interface CalculationVatService {
    public Double calculateVat(String code, String type);
    public Double calculateCurrencyExchange(String inputCode, String outputCode, Double amount);
}
