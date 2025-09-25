package com.overlookhotel.crazyhotel.service;

import com.overlookhotel.crazyhotel.entity.Employee;
import com.overlookhotel.crazyhotel.repository.EmployeeRepository;
import com.overlookhotel.crazyhotel.security.EmployeeDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StaffLoginServiceImpl implements StaffLoginService {

    private static final Logger logger = LoggerFactory.getLogger(StaffLoginServiceImpl.class);

    private final EmployeeRepository employeeRepository;

    @Autowired
    public StaffLoginServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        logger.debug("Attempting to load employee with email: {}", email);

        Employee employee = employeeRepository.findByEmail(email)
                .orElseThrow(() -> {
                    logger.warn("No employee found with email: {}", email);

                    return new UsernameNotFoundException("Aucun compte employée trouvé avec cet email.");
                });

        logger.info("Employee found for email: {}", email);
        return new EmployeeDetails(employee);
    }
}
