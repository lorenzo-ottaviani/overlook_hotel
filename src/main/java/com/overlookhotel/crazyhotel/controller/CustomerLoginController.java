package com.overlookhotel.crazyhotel.controller;

import com.overlookhotel.crazyhotel.service.CustomerLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerLoginController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerLoginController.class);

    private final CustomerLoginService loginService;

    @Autowired
    public CustomerLoginController(CustomerLoginService customerLoginService) {
        this.loginService = customerLoginService;
    }

    @GetMapping("/customer/login")
    public String showLoginForm() {
        return "customer/customer-login";
    }

}
