package com.overlookhotel.crazyhotel.controller;

import com.overlookhotel.crazyhotel.service.StaffLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String showLoginForm() {
        return "staff/staff-login";
    }

}
