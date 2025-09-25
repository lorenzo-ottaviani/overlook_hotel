//package com.overlookhotel.crazyhotel.config;
//
////import com.overlookhotel.crazyhotel.security.CustomStaffAuthenticationSuccessHandler;
////import com.overlookhotel.crazyhotel.service.CustomerLoginService;
////import com.overlookhotel.crazyhotel.service.StaffLoginService;
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.authentication.AuthenticationManager;
////import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////import org.springframework.security.crypto.password.PasswordEncoder;
////import org.springframework.security.web.SecurityFilterChain;
////
////@Configuration
////@EnableWebSecurity
////public class SecurityConfig {
////
////    private final StaffLoginService staffLoginService;
////    private final CustomerLoginService customerLoginService;
////    private final CustomStaffAuthenticationSuccessHandler staffSuccessHandler;
////
////    public SecurityConfig(StaffLoginService staffLoginService,
////                             CustomerLoginService customerLoginService,
////                             CustomStaffAuthenticationSuccessHandler staffSuccessHandler) {
////        this.staffLoginService = staffLoginService;
////        this.customerLoginService = customerLoginService;
////        this.staffSuccessHandler = staffSuccessHandler;
////    }
////
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        http
////                .securityMatcher("/h2-console/**", "/staff/**", "/admin/**", "/employee/**", "/staff/login",
////                        "/staff/process-login", "/customer/**", "/customer/login", "/customer/process-login", "/customer/register")
////                .authorizeHttpRequests(authz -> authz
////                                .requestMatchers("/staff/login", "/staff/process-login", "/customer/login",
////                                        "/customer/process-login", "/customer/register").permitAll()
////                                .requestMatchers("/admin/**").hasRole("ADMIN")
////                                .requestMatchers("/employee/**").hasRole("EMPLOYEE")
////                                .requestMatchers("/customer/**").hasRole("CUSTOMER")
////                                .requestMatchers("/stats").authenticated()
////                        // .anyRequest().authenticated()
////                )
////                .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
////                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
////                .formLogin(customerForm -> customerForm
////                        .loginPage("/customer/login")
////                        .loginProcessingUrl("/customer/process-login")
////                        .usernameParameter("email")
////                        .passwordParameter("password")
////                        .defaultSuccessUrl("/customer/dashboard", true)
////                        .failureUrl("/customer/login?error=true")
////                        .permitAll()
////                )
////                .formLogin(staffForm -> staffForm
////                        .loginPage("/staff/login")
////                        .loginProcessingUrl("/staff/process-login")
////                        .usernameParameter("email")
////                        .passwordParameter("password")
////                        .successHandler(staffSuccessHandler)
////                        .failureUrl("/staff/login?error=true")
////                        .permitAll()
////                )
////                .logout(logout -> logout
////                        .logoutUrl("/customer/logout")
////                        .logoutSuccessUrl("/customer/login?logout")
////                        .permitAll()
////                )
////                .authenticationManager(authenticationManager(http));
////
////        return http.build();
////    }
////
////    @Bean
////    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
////        AuthenticationManagerBuilder builder =
////                http.getSharedObject(AuthenticationManagerBuilder.class);
////
////        builder
////                .userDetailsService(staffLoginService)
////                .passwordEncoder(passwordEncoder());
////
////        builder
////                .userDetailsService(customerLoginService)
////                .passwordEncoder(passwordEncoder());
////
////        return builder.build();
////    }
////
////    @Bean
////    public PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
////}
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@Order(0)
//@EnableWebSecurity
//public class SecurityConfig {
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}