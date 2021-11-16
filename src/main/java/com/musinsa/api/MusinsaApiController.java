package com.musinsa.api;

import com.musinsa.domain.service.ShortenUrlservice;
import com.musinsa.exception.NoResultFoundException;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/musinsa")
@ApiResponses(value = {
        @ApiResponse(code = 400, message = "Wrong Type Parameter"),
        @ApiResponse(code = 404, message = "Not found shorten url"),
        @ApiResponse(code = 500, message = "Server Error")})
public class MusinsaApiController {
    @Autowired
    private ShortenUrlservice shortenUrlservice;

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public String createShortenUrl(String originalUrl)  throws Exception {
        return shortenUrlservice.createShortenUrl(originalUrl).getShortenUrl();
    }

    @RequestMapping(path = "/{shortenUrl}", method = RequestMethod.GET)
    public String moveOriginalUrl(@PathVariable String shortenUrl) throws Exception {
        return shortenUrlservice.getOriginalUrl(shortenUrl).getOriginalUrl();
    }
}
