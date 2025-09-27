package com.overlookhotel.crazyhotel.controller;

import com.overlookhotel.crazyhotel.dto.RegisterForm;
import com.overlookhotel.crazyhotel.service.StaffLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaffLoginController {

    private static final Logger logger = LoggerFactory.getLogger(StaffLoginController.class);

    private final StaffLoginService loginService;

    @Autowired
    public StaffLoginController(StaffLoginService staffLoginService) {
        this.loginService = staffLoginService;
    }

    @GetMapping("/staff/login")
    public String showStaffLoginPage() {
        logger.debug("Display of the staff login page.");
        return "staff/staff-login";
    }

    @GetMapping("/customer/login/from-staff-login")
    public String switchToCustomerLoginPageFromStaffLogin() {
        logger.debug("Switch to the customer login page.");
        return "customer/customer-login";
    }

    @GetMapping("/customer/register/from-staff-login")
    public String switchToCustomerRegisterPageFromStaffLogin(Model model) {
        logger.debug("Switch to the customer register page.");
        model.addAttribute("registerForm", new RegisterForm());
        return "customer/customer-register";
    }

}
