package com.musinsa.domain.dto;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "T_SHORTEN_URL")
@Entity
public class ShortenUrl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long seq;

    @Column(name = "ORIGINAL_URL")
    private String originalUrl;

    @Column(name = "SHORTEN_URL")
    private String shortenUrl;

    @Column(name = "COUNT")
    private int count;
}
