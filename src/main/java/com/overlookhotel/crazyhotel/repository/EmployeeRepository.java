package com.overlookhotel.crazyhotel.repository;

import com.overlookhotel.crazyhotel.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
