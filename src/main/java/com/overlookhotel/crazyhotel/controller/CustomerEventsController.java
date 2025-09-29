package com.overlookhotel.crazyhotel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer/events")
public class CustomerEventsController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerEventsController.class);

    @GetMapping("")
    public String showCustomerEventsPage() {
        logger.debug("Display of the customer events page.");
        return "customer/customer-events";
    }
}
