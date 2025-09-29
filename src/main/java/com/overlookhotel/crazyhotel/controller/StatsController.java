package com.overlookhotel.crazyhotel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stats")
public class StatsController {
    private static final Logger logger = LoggerFactory.getLogger(StatsController.class);

    @GetMapping("")
    public String showStatsPage() {
        logger.debug("Display of the stats page.");
        return "stats/stats";
    }
}
