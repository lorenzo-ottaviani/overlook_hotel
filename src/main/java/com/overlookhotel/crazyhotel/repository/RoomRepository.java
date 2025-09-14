package com.overlookhotel.crazyhotel.repository;

import com.overlookhotel.crazyhotel.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
