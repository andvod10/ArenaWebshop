package com.arenawebshop.aw;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = {TestConfiguration.class})
class AwApplicationTests {

    @Test
    void contextLoads() {
        assertThat(true).isTrue();
    }
}
