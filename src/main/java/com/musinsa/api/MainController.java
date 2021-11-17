package com.musinsa.api;

import com.musinsa.domain.service.ShortenUrlservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping
public class MainController {
    @Autowired
    private ShortenUrlservice shortenUrlservice;

    @GetMapping(path = "/main")
    public String welcome() {
        return "main";
    }

    @GetMapping(path = "/redirect/{shortenUrl}")
    public RedirectView redirectOriginalUrl(@PathVariable String shortenUrl) throws Exception {
        return new RedirectView (shortenUrlservice.getOriginalUrl(shortenUrl).getOriginalUrl());
    }
}
