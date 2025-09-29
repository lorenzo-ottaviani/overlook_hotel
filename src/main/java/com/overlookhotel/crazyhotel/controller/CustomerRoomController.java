package com.overlookhotel.crazyhotel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer/room")
public class CustomerRoomController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerRoomController.class);

    @GetMapping("")
    public String showCustomerRoomPage() {
        logger.debug("Display of the customer room page.");
        return "customer/customer-room";
    }
}
