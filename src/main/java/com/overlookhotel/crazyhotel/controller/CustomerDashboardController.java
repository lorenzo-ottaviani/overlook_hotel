package com.overlookhotel.crazyhotel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer/dashboard")
public class CustomerDashboardController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerDashboardController.class);

    @GetMapping("")
    public String showCustomerDashboardPage() {
        logger.debug("Display of the customer dashboard page.");
        return "customer/customer-dashboard";
    }
}
