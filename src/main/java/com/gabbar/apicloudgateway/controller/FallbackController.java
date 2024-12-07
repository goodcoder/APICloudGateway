package com.gabbar.apicloudgateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/serviceAFallBack")
    public String serviceAFallBack() {
        return "Service A is down!";
    }

    @GetMapping("/serviceBFallBack")
    public String serviceBFallBack() {
        return "Service B down!";
    }
}
