package com.overlookhotel.crazyhotel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/user-management")
public class AdminUserManagementController {
    private static final Logger logger = LoggerFactory.getLogger(AdminUserManagementController.class);

    @GetMapping("")
    public String showAdminUserManagementPage() {
        logger.debug("Display of the admin user management page.");
        return "admin/admin-user-management";
    }
}
