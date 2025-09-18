package com.overlookhotel.crazyhotel.service;

import com.overlookhotel.crazyhotel.dto.RegisterForm;
import com.overlookhotel.crazyhotel.entity.Customer;
import com.overlookhotel.crazyhotel.entity.Status;
import com.overlookhotel.crazyhotel.repository.CustomerRepository;
import com.overlookhotel.crazyhotel.repository.StatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerRegisterServiceImpl implements CustomerRegisterService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerRegisterServiceImpl.class);

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    private final StatusRepository statusRepository;

    // Constructor
    @Autowired
    public CustomerRegisterServiceImpl(CustomerRepository customerRepository, PasswordEncoder passwordEncoder,
                                       StatusRepository statusRepository) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
        this.statusRepository = statusRepository;
    }

    @Override
    public void registerCustomer(RegisterForm form) throws Exception {
        logger.info("Start client registration with email = {}", form.getEmail());

        if (customerRepository.existsByEmail(form.getEmail())) {
            logger.warn("Attempted registration with email already used: {}", form.getEmail());
            throw new Exception("This email is already used.");
        }

        Customer customer = new Customer();
        customer.setFirstName(form.getFirstName());
        customer.setLastName(form.getLastName());
        customer.setAddress(form.getAddress());
        customer.setEmail(form.getEmail());
        customer.setPassword(passwordEncoder.encode(form.getPassword()));
        customer.setPhoneNumber(form.getPhoneNumber());

        // Assign status CUSTOMER
        Status customerStatus = statusRepository.findByName("CUSTOMER")
                .orElseThrow(() -> new IllegalStateException("Status CUSTOMER not found in database"));
        customer.setStatus(customerStatus);

        customerRepository.save(customer);

        logger.info("Successful customer registration for email = {}", form.getEmail());
    }
}
