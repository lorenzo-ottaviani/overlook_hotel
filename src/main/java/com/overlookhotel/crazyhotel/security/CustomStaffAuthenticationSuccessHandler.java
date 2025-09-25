package com.overlookhotel.crazyhotel.security;

import com.overlookhotel.crazyhotel.entity.Employee;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@Component
public class CustomStaffAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {

        Object principal = authentication.getPrincipal();

        if (principal instanceof EmployeeDetails employeeDetails) {
            Employee employee = employeeDetails.getEmployee();
            String role = employee.getStatus() != null ? employee.getStatus().getName() : "";

            if ("ADMIN".equalsIgnoreCase(role)) {
                response.sendRedirect("/admin/dashboard");
            } else {
                response.sendRedirect("/employee/dashboard");
            }
        } else {
            response.sendRedirect("/staff/login");
        }
    }
}
