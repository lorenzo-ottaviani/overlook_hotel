package com.overlookhotel.crazyhotel.repository;

import com.overlookhotel.crazyhotel.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
