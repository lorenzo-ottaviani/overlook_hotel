package com.overlookhotel.crazyhotel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/feedback")
public class AdminFeedbackController {
    private static final Logger logger = LoggerFactory.getLogger(AdminFeedbackController.class);

    @GetMapping("")
    public String showAdminFeedbackPage() {
        logger.debug("Display of the admin feedback page.");
        return "admin/admin-feedback";
    }
}
