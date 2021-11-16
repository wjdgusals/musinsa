package com.musinsa.domain.service;

import com.musinsa.domain.dto.ShortenUrl;
import com.musinsa.domain.repository.ShortenUrlRepository;
import com.musinsa.exception.InvalidParamException;
import com.musinsa.exception.NoResultFoundException;
import com.musinsa.util.ShortenUrlGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShortenUrlservice {
    @Autowired
    private ShortenUrlRepository shortenUrlRepository;
    @Autowired
    private ShortenUrlGenerator shortenUrlGenerator;

    public ShortenUrl createShortenUrl(String originalUrl)  throws InvalidParamException {

        if(originalUrl.indexOf("http://") == -1 && originalUrl.indexOf("https://") == -1){
            throw new InvalidParamException("잘못된 URL입니다.");
        }

        ShortenUrl encodedShortenUrl = shortenUrlRepository.findByOriginalUrl(originalUrl);

        if(encodedShortenUrl != null) {
            encodedShortenUrl.setCount(encodedShortenUrl.getCount()+1);
            shortenUrlRepository.save(encodedShortenUrl);

            return encodedShortenUrl;
        }

        ShortenUrl shortenUrl = new ShortenUrl();
        shortenUrl.setOriginalUrl(originalUrl);

        shortenUrlRepository.save(shortenUrl);

        shortenUrl.setShortenUrl(shortenUrlGenerator.base62Encode(shortenUrl.getSeq()));
        shortenUrlRepository.save(shortenUrl);

        return shortenUrl;
    }

    public ShortenUrl getOriginalUrl(String shortenUrl) throws NoResultFoundException {
//        ShortenUrl resultUrl = shortenUrlRepository.findByShortenUrl(shortenUrl);
        long seq = shortenUrlGenerator.base62Decode(shortenUrl);
        Optional<ShortenUrl> resultUrl = shortenUrlRepository.findById(seq);

        if(!resultUrl.isPresent()) {
            throw new NoResultFoundException("["+shortenUrl+"]해당하는 URL이 없습니다.");
        } else {
            return resultUrl.get();
        }
    }
}
