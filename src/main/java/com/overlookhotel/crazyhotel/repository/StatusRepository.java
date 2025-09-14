package com.overlookhotel.crazyhotel.repository;

import com.overlookhotel.crazyhotel.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
