//package com.overlookhotel.crazyhotel.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
//import com.overlookhotel.crazyhotel.service.CustomerLoginService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@Order(2)
//@EnableWebSecurity
//public class CustomerSecurityConfig {
//
//    private final CustomerLoginService customerLoginService;
//
//    public CustomerSecurityConfig(CustomerLoginService customerLoginService) {
//        this.customerLoginService = customerLoginService;
//    }
//
//    @Bean
//    public SecurityFilterChain customerSecurityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .securityMatcher("/customer/**", "/h2-console/**", "/customer/login", "/customer/process-login", "/customer/register")
//                .authorizeHttpRequests(authz -> authz
//                        .requestMatchers("/customer/login", "/customer/register", "/h2-console/**").permitAll()
//                        .requestMatchers("/customer/**").hasRole("CUSTOMER")
//                        // .requestMatchers("/stats").authenticated()
//                )
//                .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
//                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
//                .formLogin(form -> form
//                        .loginPage("/customer/login")
//                        .loginProcessingUrl("/customer/process-login")
//                        .usernameParameter("email")
//                        .passwordParameter("password")
//                        .defaultSuccessUrl("/customer/dashboard", true)
//                        .failureUrl("/customer/login?error=true")
//                        .permitAll()
//                )
//                .logout(logout -> logout
//                        .logoutUrl("/customer/logout")
//                        .logoutSuccessUrl("/customer/login?logout")
//                        .permitAll()
//                )
//                .authenticationManager(customerAuthenticationManager(http));
//
//        return http.build();
//    }
//
//    @Bean
//    @Primary
//    public AuthenticationManager customerAuthenticationManager(HttpSecurity http) throws Exception {
//        AuthenticationManagerBuilder builder = http.getSharedObject(AuthenticationManagerBuilder.class);
//        builder.userDetailsService(customerLoginService).passwordEncoder(new BCryptPasswordEncoder());
//        return builder.build();
//    }
//}
