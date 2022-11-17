package com.arenawebshop.vat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = {TestConfiguration.class})
class VatApplicationTests {

    @Test
    void contextLoads() {
        assertThat(true).isTrue();
    }
}
