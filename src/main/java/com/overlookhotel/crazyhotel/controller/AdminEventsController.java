package com.overlookhotel.crazyhotel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/events")
public class AdminEventsController {
        private static final Logger logger = LoggerFactory.getLogger(AdminEventsController.class);

    @GetMapping("")
    public String showAdminEventsPage() {
        logger.debug("Display of the admin events page.");
        return "admin/admin-events";
    }
}
