package com.overlookhotel.crazyhotel.service;

import com.overlookhotel.crazyhotel.entity.Customer;
import com.overlookhotel.crazyhotel.repository.CustomerRepository;
import com.overlookhotel.crazyhotel.security.CustomerDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerLoginServiceImpl implements CustomerLoginService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerLoginServiceImpl.class);

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerLoginServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        logger.debug("Attempting to load customer with email: {}", email);

        Customer customer = customerRepository.findByEmail(email)
                .orElseThrow(() -> {
                    logger.warn("No customer found with email: {}", email);

                    return new UsernameNotFoundException("Aucun compte client trouvé avec cet email.");
                });

        logger.info("Customer found for email: {}", email);
        return new CustomerDetails(customer);
    }
}
