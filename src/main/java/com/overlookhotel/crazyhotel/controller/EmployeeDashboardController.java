package com.overlookhotel.crazyhotel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee/dashboard")
public class EmployeeDashboardController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeDashboardController.class);

    @GetMapping("")
    public String showEmployeeDashboardPage() {
        logger.debug("Display of the employee dashboard page.");
        return "employee/employee-dashboard";
    }
}
