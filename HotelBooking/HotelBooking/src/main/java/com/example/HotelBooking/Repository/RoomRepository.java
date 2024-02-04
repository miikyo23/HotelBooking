package com.example.HotelBooking.Repository;

import com.example.HotelBooking.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {
}
