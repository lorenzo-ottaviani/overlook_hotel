package com.overlookhotel.crazyhotel.config;

import com.overlookhotel.crazyhotel.entity.Status;
import com.overlookhotel.crazyhotel.repository.StatusRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    public ApplicationRunner initStatuses(StatusRepository statusRepository) {
        return args -> {
            List<String> defaultStatuses = List.of("CUSTOMER", "ADMIN", "EMPLOYEE");

            for (String statusName : defaultStatuses) {
                statusRepository.findByName(statusName)
                        .orElseGet(() -> {
                            Status status = new Status(statusName);
                            return statusRepository.save(status);
                        });
            }
        };
    }
}

