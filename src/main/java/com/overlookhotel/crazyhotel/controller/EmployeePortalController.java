package com.overlookhotel.crazyhotel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee/portal")
public class EmployeePortalController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeePortalController.class);

    @GetMapping("")
    public String showEmployeePortalPage() {
        logger.debug("Display of the employee portal page.");
        return "customer/employee-portal";
    }
}
