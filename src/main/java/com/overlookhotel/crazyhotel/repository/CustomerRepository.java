package com.overlookhotel.crazyhotel.repository;

import com.overlookhotel.crazyhotel.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsByEmail(String email);

    Optional<Customer> findByEmail(String email);
}

