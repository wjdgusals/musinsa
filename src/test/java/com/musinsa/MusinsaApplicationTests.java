package com.musinsa;

import com.musinsa.domain.dto.ShortenUrl;
import com.musinsa.domain.service.ShortenUrlservice;
import com.musinsa.exception.InvalidParamException;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest
class MusinsaApplicationTests {
    @Autowired
    private ShortenUrlservice shortenUrlservice;

    @Rule
    public ExpectedException expectedException;

    @Test
    void contextLoads() {
    }

    @Test
    void invalidUrlTest() {
        InvalidParamException exception = assertThrows(InvalidParamException.class,
                                                        ()-> shortenUrlservice.createShortenUrl("invalid url"));
        String message = exception.getMessage();
        assertEquals("잘못된 URL입니다.", message);
    }

    @Test
    void createShortenUrl() {
        ShortenUrl shortenUrl = shortenUrlservice.createShortenUrl("http://www.naver.com");

        assertEquals("000q0V", shortenUrl.getShortenUrl());

        shortenUrl = shortenUrlservice.createShortenUrl("http://www.musinsa.com");

        assertEquals("000q0W", shortenUrl.getShortenUrl());
    }
}
