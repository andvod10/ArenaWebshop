package com.arenawebshop.aw.service.price;

import com.arenawebshop.aw.configuration.TestConfigurations;
import com.arenawebshop.aw.presentation.dto.RsPrice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private CalculationPriceService calculationPriceService;

    @Test
    void calculateTotalPriceWithoutAdditionalItems() {
        double totalPrice = 50 + 8 * 15.5;

        RsPrice rsPrice = this.calculationPriceService.calculateTotalPrice("-a", "8", "-p", "15.5");

        assertThat(rsPrice.getPrice()).isEqualTo(totalPrice);
    }

    @Test
    void calculateTotalPriceWithAdditionalItems() {
        double totalPrice = 50 + 2 * 25 + 28 * 15.5;

        RsPrice rsPrice = this.calculationPriceService.calculateTotalPrice("-a", "28", "-p", "15.5");

        assertThat(rsPrice.getPrice()).isEqualTo(totalPrice);
    }
}
