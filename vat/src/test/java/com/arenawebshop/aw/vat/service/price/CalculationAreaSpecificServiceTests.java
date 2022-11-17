package com.arenawebshop.aw.vat.service.price;

import com.arenawebshop.aw.vat.configuration.TestConfigurations;
import com.arenawebshop.aw.vat.data.entity.Currency;
import com.arenawebshop.aw.vat.presentation.dto.RsPrice;
import com.arenawebshop.aw.vat.service.vat.CalculationAreaSpecificServiceImpl;
import com.arenawebshop.aw.vat.service.vat.CurrencyService;
import com.arenawebshop.aw.vat.service.vat.VatService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ContextConfiguration(classes = {TestConfigurations.class})
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
class CalculationAreaSpecificServiceTests {
    @InjectMocks
    private CalculationAreaSpecificServiceImpl calculationAreaSpecificService;

    @Mock
    private VatService vatService;
    @Mock
    private CurrencyService currencyService;

    @Test
    void calculateTotalPriceWithoutCurrency() {
        double totalPrice = 174;
        double vatRate = 25.0;
        Mockito.when(vatService
                .calculateVat(Mockito.anyString(), Mockito.any()))
                .thenReturn(vatRate);
        Mockito.when(currencyService
                .calculateCurrencyExchange(Mockito.any(), Mockito.any(), Mockito.anyDouble()))
                .thenReturn(totalPrice);

        RsPrice rsPrice = this.calculationAreaSpecificService.calculateVatAndCurrencyExchange(totalPrice,
                "-t", "BOOK",
                "--input-currency", "DKK",
                "--vat", "DK",
                "--output-currency", "DKK");
        Mockito.verify(vatService).calculateVat(Mockito.anyString(), Mockito.any());
        Mockito.verify(currencyService).calculateCurrencyExchange(Mockito.any(), Mockito.any(), Mockito.anyDouble());

        assertThat(rsPrice.getPrice()).isEqualTo(totalPrice + totalPrice * vatRate / 100);
        assertThat(rsPrice.getCurrency()).isEqualTo(Currency.DKK);
    }

    @Test
    void calculateTotalPriceWithCurrency() {
        double totalPrice = 274;
        double inputCurrency = 75.7;
        double outputCurrency = 214;
        double vatRate = 25.0;
        Mockito.when(vatService
                .calculateVat(Mockito.anyString(), Mockito.any()))
                .thenReturn(vatRate);
        Mockito.when(currencyService
                .calculateCurrencyExchange(Mockito.any(), Mockito.any(), Mockito.anyDouble()))
                .thenReturn(totalPrice);

        RsPrice rsPrice = this.calculationAreaSpecificService.calculateVatAndCurrencyExchange(totalPrice,
                "-t", "BOOK",
                "--input-currency", "NOK",
                "--vat", "DK",
                "--output-currency", "EUR");
        Mockito.verify(vatService).calculateVat(Mockito.anyString(), Mockito.any());
        Mockito.verify(currencyService).calculateCurrencyExchange(Mockito.any(), Mockito.any(), Mockito.anyDouble());

        assertThat(rsPrice.getPrice()).isEqualTo(totalPrice + totalPrice * vatRate / 100);
        assertThat(rsPrice.getCurrency()).isEqualTo(Currency.EUR);
    }
}
