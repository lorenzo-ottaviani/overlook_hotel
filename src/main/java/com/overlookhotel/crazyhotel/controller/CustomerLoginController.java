package com.overlookhotel.crazyhotel.controller;

import com.overlookhotel.crazyhotel.dto.RegisterForm;
import com.overlookhotel.crazyhotel.service.CustomerLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer/login")
public class CustomerLoginController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerLoginController.class);

    private final CustomerLoginService loginService;

    @Autowired
    public CustomerLoginController(CustomerLoginService customerLoginService) {
        this.loginService = customerLoginService;
    }

    @GetMapping("")
    public String showCustomerLoginPage() {
        logger.debug("Display of the customer login page.");
        return "customer/customer-login";
    }
}
