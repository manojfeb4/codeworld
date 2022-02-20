package com.ctm.insurance;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringKafkaDemoApplicationTests {

    @Test
    void contextLoads() {
        assertEquals(2, 1+1);
    }

}
