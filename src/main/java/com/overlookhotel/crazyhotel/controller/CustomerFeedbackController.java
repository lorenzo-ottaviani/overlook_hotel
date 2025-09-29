package com.overlookhotel.crazyhotel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer/feedback")
public class CustomerFeedbackController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerFeedbackController.class);

    @GetMapping("")
    public String showCustomerFeedbackPage() {
        logger.debug("Display of the customer feedback page.");
        return "customer/customer-feedback";
    }
}
