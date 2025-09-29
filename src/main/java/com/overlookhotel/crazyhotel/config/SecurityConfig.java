package com.overlookhotel.crazyhotel.config;

import com.overlookhotel.crazyhotel.security.CustomStaffAuthenticationSuccessHandler;
import com.overlookhotel.crazyhotel.service.CustomerLoginService;
import com.overlookhotel.crazyhotel.service.StaffLoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final StaffLoginService staffLoginService;
    private final CustomerLoginService customerLoginService;
    private final CustomStaffAuthenticationSuccessHandler successHandler;

    public SecurityConfig(StaffLoginService staffLoginService,
                          CustomerLoginService customerLoginService,
                          CustomStaffAuthenticationSuccessHandler successHandler) {
        this.staffLoginService = staffLoginService;
        this.customerLoginService = customerLoginService;
        this.successHandler = successHandler;
    }

    @Bean
    public SecurityFilterChain staffSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/staff/**", "/admin/**", "/employee/**", "/staff/login", "/staff/process-login")
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/staff/login", "/staff/process-login").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/employee/**").hasRole("EMPLOYEE")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/staff/login")
                        .loginProcessingUrl("/staff/process-login")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .successHandler(successHandler)
                        .failureUrl("/staff/login?error=true")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/staff/logout")
                        .logoutSuccessUrl("/staff/login?logout")
                        .permitAll()
                )
                .authenticationProvider(staffAuthenticationProvider(staffLoginService));

        return http.build();
    }

    @Bean
    public SecurityFilterChain customerSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/customer/**", "/h2-console/**", "/customer/login", "/customer/process-login",
                        "/customer/register", "/stats")
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/customer/login", "/customer/register", "/h2-console/**", "/customer/process-login").permitAll()
                        .requestMatchers("/customer/**").hasRole("CUSTOMER")
                        .requestMatchers("/stats").authenticated()
                )
                .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
                .formLogin(form -> form
                        .loginPage("/customer/login")
                        .loginProcessingUrl("/customer/process-login")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/customer/dashboard", true)
                        .failureUrl("/customer/login?error=true")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/customer/logout")
                        .logoutSuccessUrl("/customer/login?logout")
                        .permitAll()
                )
                .authenticationProvider(customerAuthenticationProvider(customerLoginService));

        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider staffAuthenticationProvider(StaffLoginService userDetailService) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailService);
        authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return authProvider;
    }

    @Bean
    public DaoAuthenticationProvider customerAuthenticationProvider(CustomerLoginService userDetailService) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailService);
        authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
