package com.overlookhotel.crazyhotel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerDashboardController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerDashboardController.class);

    @GetMapping("/customer/dashboard")
    public String showCustomerDashboardPage() {
        logger.debug("Display of the customer dashboard page.");
        return "customer/customer-dashboard";
    }
}
