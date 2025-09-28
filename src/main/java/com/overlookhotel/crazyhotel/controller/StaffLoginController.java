package com.overlookhotel.crazyhotel.controller;

import com.overlookhotel.crazyhotel.dto.RegisterForm;
import com.overlookhotel.crazyhotel.service.StaffLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/staff/login")
public class StaffLoginController {

    private static final Logger logger = LoggerFactory.getLogger(StaffLoginController.class);

    private final StaffLoginService loginService;

    @Autowired
    public StaffLoginController(StaffLoginService staffLoginService) {
        this.loginService = staffLoginService;
    }

    @GetMapping("")
    public String showStaffLoginPage() {
        logger.debug("Display of the staff login page.");
        return "staff/staff-login";
    }
}
