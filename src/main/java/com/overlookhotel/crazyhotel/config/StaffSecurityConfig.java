//package com.overlookhotel.crazyhotel.config;
//
//import com.overlookhotel.crazyhotel.security.CustomStaffAuthenticationSuccessHandler;
//import com.overlookhotel.crazyhotel.service.StaffLoginService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@Order(1)
//@EnableWebSecurity
//public class StaffSecurityConfig {
//
//    private final StaffLoginService staffLoginService;
//    private final CustomStaffAuthenticationSuccessHandler successHandler;
//
//    public StaffSecurityConfig(StaffLoginService staffLoginService,
//                               CustomStaffAuthenticationSuccessHandler successHandler) {
//        this.staffLoginService = staffLoginService;
//        this.successHandler = successHandler;
//    }
//
//    @Bean
//    public SecurityFilterChain staffSecurityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .securityMatcher("/staff/**", "/admin/**", "/employee/**", "/staff/login", "/staff/process-login")
//                .authorizeHttpRequests(authz -> authz
//                        .requestMatchers("/staff/login", "/staff/process-login").permitAll()
//                        .requestMatchers("/admin/**").hasRole("ADMIN")
//                        .requestMatchers("/employee/**").hasRole("EMPLOYEE")
//                        .anyRequest().authenticated()
//                )
//                .formLogin(form -> form
//                        .loginPage("/staff/login")
//                        .loginProcessingUrl("/staff/process-login")
//                        .usernameParameter("email")
//                        .passwordParameter("password")
//                        .successHandler(successHandler)
//                        .failureUrl("/staff/login?error=true")
//                        .permitAll()
//                )
//                .logout(logout -> logout
//                        .logoutUrl("/staff/logout")
//                        .logoutSuccessUrl("/staff/login?logout")
//                        .permitAll()
//                )
//                .authenticationManager(staffAuthenticationManager(http));
//
//        return http.build();
//    }
//
//    @Bean
//    public AuthenticationManager staffAuthenticationManager(HttpSecurity http) throws Exception {
//        AuthenticationManagerBuilder builder = http.getSharedObject(AuthenticationManagerBuilder.class);
//        builder.userDetailsService(staffLoginService).passwordEncoder(new BCryptPasswordEncoder());
//        return builder.build();
//    }
//}
