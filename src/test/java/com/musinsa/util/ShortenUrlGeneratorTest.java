package com.musinsa.util;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ShortenUrlGeneratorTest {
    @Autowired ShortenUrlGenerator shortenUrlGenerator;

    @Test
    void encodeTest() {
        long value = 1234567l;
        String shortenUrl = shortenUrlGenerator.base62Encode(value);

        assertEquals("005ban", shortenUrl);
    }

    @Test
    void decodeTest() {
        String encodedUrl = "005ban";
        long oringinValue = shortenUrlGenerator.base62Decode(encodedUrl);

        assertEquals(1234567l, oringinValue);
    }
}