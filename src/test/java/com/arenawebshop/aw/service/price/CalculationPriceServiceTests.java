package com.arenawebshop.aw.service.price;

import com.arenawebshop.aw.configuration.TestConfigurations;
import com.arenawebshop.aw.data.entity.Currency;
import com.arenawebshop.aw.data.entity.ProductType;
import com.arenawebshop.aw.presentation.dto.RqTotalPrice;
import com.arenawebshop.aw.presentation.dto.RsTotalPrice;
import com.arenawebshop.aw.vat.service.vat.CalculationVatService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = {TestConfigurations.class})
@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(properties = {
        "freight.price=50",
        "freight.items=10",
        "freight.additional-price=25",
        "freight.additional-items=10",
})
@ExtendWith(SpringExtension.class)
class CalculationPriceServiceTests {
    @InjectMocks
    private CalculationPriceServiceImpl calculationPriceService;

    @Mock
    private CalculationVatService calculationVatService;

    @Test
    void calculateTotalPriceWithoutAdditionalItems() {
        double totalPrice = 50 + 8 * 15.5;
        double vatRate = 25.0;
        Mockito.when(calculationVatService
                .calculateCurrencyExchange(Mockito.anyString(), Mockito.anyString(), Mockito.anyDouble()))
                .thenReturn(totalPrice);
        Mockito.when(calculationVatService
                .calculateVat(Mockito.anyString(), Mockito.anyString()))
                .thenReturn(vatRate);

        RqTotalPrice rqTotalPrice = RqTotalPrice.builder()
                .amount(8)
                .price(15.5)
                .type(ProductType.BOOK)
                .vat("DK")
                .build();
        RsTotalPrice rsTotalPrice = this.calculationPriceService.calculateTotalPrice(rqTotalPrice);
        Mockito.verify(calculationVatService).calculateVat(Mockito.anyString(), Mockito.anyString());
        Mockito.verify(calculationVatService).calculateCurrencyExchange(Mockito.anyString(), Mockito.anyString(), Mockito.anyDouble());

        assertThat(rsTotalPrice.getTotalPrice()).isEqualTo(totalPrice + totalPrice * vatRate / 100);
        assertThat(rsTotalPrice.getCurrency()).isEqualTo(Currency.DKK);
    }

    @Test
    void calculateTotalPriceWithAdditionalItems() {
        double totalPrice = 50 + 2 * 25 + 28 * 15.5;
        double vatRate = 25.0;
        Mockito.when(calculationVatService
                .calculateCurrencyExchange(Mockito.anyString(), Mockito.anyString(), Mockito.anyDouble()))
                .thenReturn(totalPrice);
        Mockito.when(calculationVatService
                .calculateVat(Mockito.anyString(), Mockito.anyString()))
                .thenReturn(vatRate);

        RqTotalPrice rqTotalPrice = RqTotalPrice.builder()
                .amount(28)
                .price(15.5)
                .type(ProductType.BOOK)
                .vat("DK")
                .build();
        RsTotalPrice rsTotalPrice = this.calculationPriceService.calculateTotalPrice(rqTotalPrice);
        assertThat(rsTotalPrice.getTotalPrice()).isEqualTo(totalPrice + totalPrice * vatRate / 100);
        assertThat(rsTotalPrice.getCurrency()).isEqualTo(Currency.DKK);
    }
}
