package com.overlookhotel.crazyhotel.controller;

import com.overlookhotel.crazyhotel.dto.RegisterForm;
import com.overlookhotel.crazyhotel.service.CustomerRegisterService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer/register")
public class CustomerRegisterController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerRegisterController.class);

    private final CustomerRegisterService customerRegisterService;

    @Autowired
    public CustomerRegisterController(CustomerRegisterService customerRegisterService) {
        this.customerRegisterService = customerRegisterService;
    }

    @GetMapping("")
    public String showCustomerRegisterPage(Model model) {
        logger.debug("Display of the customer registration page.");
        model.addAttribute("registerForm", new RegisterForm());
        return "customer/customer-register";
    }

    @PostMapping("")
    public String processRegister( @Valid @ModelAttribute("registerForm") RegisterForm registerForm,
            BindingResult bindingResult, Model model) {

        logger.debug("Processing the registration for email = {}", registerForm.getEmail());

        if (bindingResult.hasErrors()) {
            logger.warn("Validation errors during registration for email = {}", registerForm.getEmail());
            return "customer/customer-register";
        }

        try {
            customerRegisterService.registerCustomer(registerForm);
            logger.info("Successful registration for email {}", registerForm.getEmail());
        } catch (Exception e) {
            logger.warn("Error during the registration for the email {}: {} ", registerForm.getEmail(), e.getMessage());
            model.addAttribute("registrationError", e.getMessage());
            return "customer/customer-register";
        }

        // Once successful, redirect to the client login page.
        return "redirect:/customer/login";
    }
}
