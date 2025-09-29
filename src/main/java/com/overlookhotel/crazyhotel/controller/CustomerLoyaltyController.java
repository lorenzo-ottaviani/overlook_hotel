package com.overlookhotel.crazyhotel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer/loyalty")
public class CustomerLoyaltyController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerLoyaltyController.class);

    @GetMapping("")
    public String showCustomerLoyaltyPage() {
        logger.debug("Display of the customer loyalty page.");
        return "customer/customer-loyalty";
    }
}
