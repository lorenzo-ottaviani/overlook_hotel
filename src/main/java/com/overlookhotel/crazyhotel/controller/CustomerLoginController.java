package com.overlookhotel.crazyhotel.controller;

import com.overlookhotel.crazyhotel.dto.RegisterForm;
import com.overlookhotel.crazyhotel.service.CustomerLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String showCustomerLoginPage() {
        logger.debug("Display of the customer login page.");
        return "customer/customer-login";
    }

    @GetMapping("/staff/login/from-customer-login")
    public String switchToStaffLoginPageFromCustomerLogin() {
        logger.debug("Switch to the staff login page.");
        return "staff/staff-login";
    }

    @GetMapping("/customer/register/from-customer-login")
    public String switchToCustomerRegisterPageFromCustomerLogin(Model model) {
        logger.debug("Switch to the customer register page.");
        model.addAttribute("registerForm", new RegisterForm());
        return "customer/customer-register";
    }

}
