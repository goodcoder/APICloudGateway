package com.gabbar.apicloudgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


    @RestController
    public class ServiceDownHandlerController {

        @GetMapping("/orderServiceFallBack")
        public String orderServiceFallback() {
            return "Order Service is down!";
        }

        @GetMapping("/paymentServiceFallBack")
        public String paymentServiceFallback() {
            return "Payment Service is down!";
        }

        @GetMapping("/productServiceFallBack")
        public String productServiceFallback() {
            return "Product Service is down!";
        }

    }