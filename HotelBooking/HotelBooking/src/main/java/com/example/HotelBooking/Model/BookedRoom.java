package com.example.HotelBooking.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "booked_room")
public class BookedRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookingId;
    @Column(name = "check_In")
    private LocalDate checkInDate;
    @Column(name = "check_Out")
    private LocalDate checkOutDate;
    @Column(name = "guest_FullName")
    private String guestName;
    @Column(name = "guest_Email")
    private String guestEmail;
    @Column(name = "adults")
    private int NumOfAdult;
    @Column(name = "kids")
    private int NumOfKids;
    @Column(name = "total_Num_Of_Guest")
    private int totalNumOfGuest;
    @Column(name = "booking_Confirmation")
    private String bookingConfirmationCode;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    public void calculateTotalNumOfGuest(){
        this.totalNumOfGuest = this.NumOfAdult + this.NumOfKids;
    }

    public void setNumOfAdult(int numOfAdult) {
        NumOfAdult = numOfAdult;
        calculateTotalNumOfGuest();
    }

    public void setNumOfKids(int numOfKids) {
        NumOfKids = numOfKids;
        calculateTotalNumOfGuest();
    }

    public void setBookingConfirmationCode(String bookingConfirmationCode) {
        this.bookingConfirmationCode = bookingConfirmationCode;
    }
}
