package com.overlookhotel.crazyhotel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeDashboardController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeDashboardController.class);

    @GetMapping("/employee/dashboard")
    public String showEmployeeDashboardPage() {
        logger.debug("Display of the employee dashboard page.");
        return "employee/employee-dashboard";
    }
}
