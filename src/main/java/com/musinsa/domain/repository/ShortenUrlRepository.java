package com.musinsa.domain.repository;

import com.musinsa.domain.dto.ShortenUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortenUrlRepository extends JpaRepository<ShortenUrl, Long> {
    ShortenUrl findByOriginalUrl(String originalUrl);
    ShortenUrl findByShortenUrl(String shortenUrl);
}
