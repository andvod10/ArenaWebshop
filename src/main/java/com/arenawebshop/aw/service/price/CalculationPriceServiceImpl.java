package com.arenawebshop.aw.service.price;

import com.arenawebshop.aw.data.entity.Currency;
import com.arenawebshop.aw.presentation.dto.RqTotalPrice;
import com.arenawebshop.aw.presentation.dto.RsTotalPrice;
import com.arenawebshop.aw.vat.service.vat.CalculationVatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.ParseException;

@Service
public class CalculationPriceServiceImpl implements CalculationPriceService {
    // It's better to hold these values in DB, for more then one freighter. And it will be easier to modify
    @Value("${freight.price}")
    private double freightPrice;
    @Value("${freight.items}")
    private int freightItems;
    @Value("${freight.additional-price}")
    private double additionalFreightPrice;
    @Value("${freight.additional-items}")
    private int additionalFreightItems;

    private CalculationVatService calculationVatService;

    @Autowired
    CalculationPriceServiceImpl(CalculationVatService calculationVatService) {
        this.calculationVatService = calculationVatService;
    }

    /**
     * The calculation is:
     * Total price = amount x price + freigh
     */
    @Override
    public RsTotalPrice calculateTotalPrice(RqTotalPrice rqTotalPrice) {
        double totalPrice = rqTotalPrice.price * rqTotalPrice.amount;
        totalPrice += calculateFreight(rqTotalPrice.amount);
        double vatRate = this.calculationVatService.calculateVat(rqTotalPrice.vat, rqTotalPrice.type.name());
        String inputCurrency = rqTotalPrice.inputCurrency != null ? rqTotalPrice.inputCurrency.name() : Currency.DKK.name();
        String outputCurrency = rqTotalPrice.outputCurrency != null ? rqTotalPrice.outputCurrency.name() : Currency.DKK.name();
        double exchangedMoney = this.calculationVatService.calculateCurrencyExchange(
                inputCurrency,
                outputCurrency,
                totalPrice);
        return RsTotalPrice.builder()
                .totalPrice(round(exchangedMoney + exchangedMoney * vatRate / 100))
                .currency(Currency.valueOf(outputCurrency))
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

    /**
     * Freight depends on the amount of products.
     * • Up to and including 10 items: 50,-
     * • For each additional 10 items: 25,-
     * For example 48 items:
     * 50 + 4 * 25
     */
    private Double calculateFreight(Integer amount) {
        return freightPrice + Math.ceil((amount - freightItems) / (double) additionalFreightItems) * additionalFreightPrice;
    }
}
