package com.pierzchala.springfive.controller;

import com.google.gson.Gson;
import com.pierzchala.springfive.lib.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ReCAPTCHA {
    private Logger LOGGER = LoggerFactory.getLogger("Logger");

    @GetMapping("/captcha")
    public String getCaptcha() {

        LOGGER.info("getCaptcha");
        return "formCaptcha";
    }

    @PostMapping("/captcha")
    public RedirectView postCaptcha(@RequestParam(value = "g-recaptcha-response") String response) {
        LOGGER.info("postCaptcha | Response: " + response);
        LOGGER.info("postCaptcha | Response: " + response.length());
        if (response.length() == 0) {
            return new RedirectView("captcha");
        }
        String url = "https://www.google.com/recaptcha/api/siteverify?secret=6LeIxAcTAAAAAGG-vFI1TnRWxMZNFuojJ4WifJWe&response=" + response;

        RestTemplate rest = new RestTemplate();
        ResponseEntity<String> exchange = rest.exchange(
                url,
                HttpMethod.POST,
                HttpEntity.EMPTY,
                String.class);

        System.out.println(exchange.getBody());
        Request request = new Gson().fromJson(exchange.getBody(), Request.class);
        if (request.isSuccess()) {
            return new RedirectView("/");
        }

        return new RedirectView("captcha");
    }
}
