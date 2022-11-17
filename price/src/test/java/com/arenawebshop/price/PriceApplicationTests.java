package com.arenawebshop.price;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = {TestConfiguration.class})
class PriceApplicationTests {

    @Test
    void contextLoads() {
        assertThat(true).isTrue();
    }
}
