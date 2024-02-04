package com.example.HotelBooking.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@Entity
@AllArgsConstructor
@Table(name = "_room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "room_type")
    private String roomType;
    @Column(name = "room_Price")
    private BigDecimal roomPrice;
    @Column(name = "is_booked")
    private boolean isBooked = false;
    @Lob
    private Blob photo;
    @OneToMany(mappedBy = "room",fetch =FetchType.LAZY,cascade = CascadeType.ALL)
    private List<BookedRoom> bookings;

    public Room(List<BookedRoom> bookings) {
        this.bookings = new ArrayList<>();
    }
    public void addBooking(BookedRoom booking){
        if(bookings == null){
            bookings = new ArrayList<>();
        }
        bookings.add(booking);
        booking.setRoom(this);
        isBooked = true;
        String bookingcode = RandomStringUtils.random(10);
        booking.setBookingConfirmationCode(bookingcode);
    }
}
