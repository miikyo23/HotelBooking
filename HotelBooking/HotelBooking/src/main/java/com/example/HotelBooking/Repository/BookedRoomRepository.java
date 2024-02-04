package com.example.HotelBooking.Repository;

import com.example.HotelBooking.Model.BookedRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookedRoomRepository extends JpaRepository<BookedRoom,Long> {
}
