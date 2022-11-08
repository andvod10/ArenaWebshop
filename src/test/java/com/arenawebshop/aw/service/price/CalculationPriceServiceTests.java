package com.arenawebshop.aw.service.price;

import com.arenawebshop.aw.configuration.TestConfigurations;
import com.arenawebshop.aw.data.entity.Currency;
import com.arenawebshop.aw.data.entity.ProductType;
import com.arenawebshop.aw.presentation.dto.RqTotalPrice;
import com.arenawebshop.aw.presentation.dto.RsTotalPrice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

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
class CalculationPriceServiceTests {
    private CalculationPriceService calculationPriceService;
    @Autowired
    CalculationPriceServiceTests(@Qualifier("calculationPriceServiceImpl") CalculationPriceService calculationPriceService) {
        this.calculationPriceService = calculationPriceService;
    }

    @Test
    void calculateTotalPriceWithoutAdditionalItems() {
        RqTotalPrice rqTotalPrice = RqTotalPrice.builder()
                .amount(8)
                .price(15.5)
                .type(ProductType.BOOK)
                .build();
        RsTotalPrice rsTotalPrice = this.calculationPriceService.calculateTotalPrice(rqTotalPrice);
        assertThat(rsTotalPrice.getTotalPrice()).isEqualTo(50 + 8 * 15.5);
        assertThat(rsTotalPrice.getCurrency()).isEqualTo(Currency.DKK);
    }

    @Test
    void calculateTotalPriceWithAdditionalItems() {
        RqTotalPrice rqTotalPrice = RqTotalPrice.builder()
                .amount(28)
                .price(15.5)
                .type(ProductType.BOOK)
                .build();
        RsTotalPrice rsTotalPrice = this.calculationPriceService.calculateTotalPrice(rqTotalPrice);
        assertThat(rsTotalPrice.getTotalPrice()).isEqualTo(50 + 2 * 25 + 28 * 15.5);
        assertThat(rsTotalPrice.getCurrency()).isEqualTo(Currency.DKK);
    }
}
