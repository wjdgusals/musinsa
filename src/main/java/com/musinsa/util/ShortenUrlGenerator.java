package com.musinsa.util;

import org.springframework.stereotype.Component;

@Component
public class ShortenUrlGenerator {
    private final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final int BASE = ALPHABET.length();

    public String base62Encode(long value) {
        StringBuilder sb = new StringBuilder();
        while (value != 0) {
            sb.append(ALPHABET.charAt((int)(value % BASE)));
            value = value / 62;
        }
        while (sb.length() < 6) {
            sb.append(0);
        }
        return sb.reverse().toString();
    }

    public long base62Decode(String encodedStr) {
        long decode = 0;
        for(int i = 0; i < encodedStr.length(); i++) {
            decode = decode * 62 + ALPHABET.indexOf("" + encodedStr.charAt(i));
        }

        return decode;
    }
}
