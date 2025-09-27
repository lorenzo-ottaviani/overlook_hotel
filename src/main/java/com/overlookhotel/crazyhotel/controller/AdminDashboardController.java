package com.overlookhotel.crazyhotel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminDashboardController {
    private static final Logger logger = LoggerFactory.getLogger(AdminDashboardController.class);

    @GetMapping("/admin/dashboard")
    public String showAdminDashboardPage() {
        logger.debug("Display of the admin dashboard page.");
        return "admin/admin-dashboard";
    }
}
