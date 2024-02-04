package com.example.HotelBooking.Response;

import com.example.HotelBooking.Model.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingResponse {
    private long bookingId;
    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private String guestName;

    private String guestEmail;

    private int NumOfAdult;

    private int NumOfKids;

    private int totalNumOfGuest;

    private String bookingConfirmationCode;

    private Room room;

    public BookingResponse(long bookingId, LocalDate checkInDate, LocalDate checkOutDate,
                           String bookingConfirmationCode) {
        this.bookingId = bookingId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.bookingConfirmationCode = bookingConfirmationCode;
    }
}
