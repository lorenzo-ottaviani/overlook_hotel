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

@Controller
public class CustomerRegisterController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerRegisterController.class);

    private final CustomerRegisterService customerRegisterService;

    @Autowired
    public CustomerRegisterController(CustomerRegisterService customerRegisterService) {
        this.customerRegisterService = customerRegisterService;
    }

    @GetMapping("/customer/register")
    public String showRegisterForm(Model model) {
        logger.debug("Display of the customer registration form.");
        model.addAttribute("registerForm", new RegisterForm());
        return "customer/customer-register";
    }

    @PostMapping("/customer/register")
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
        return "redirect:/customer/customer-login";
    }
}
