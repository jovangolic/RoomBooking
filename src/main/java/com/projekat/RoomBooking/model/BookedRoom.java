package com.projekat.RoomBooking.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "booked_rooms")
public class BookedRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_seq")
    @SequenceGenerator(name = "booking_seq", sequenceName = "booking_sequence", allocationSize = 1)
    private Long bookingId;

    @Column(name = "check_in", nullable = false)
    private LocalDate checkInDate;

    @Column(name = "check_out", nullable = false)
    private LocalDate checkOutDate;

    @Column(name = "guest_full_name", nullable = false)
    private String guestFullName; 

    @Column(name = "guest_email", nullable = false)
    private String guestEmail;

    @Column(name = "adults", nullable = false)
    private int numOfAdults;

    @Column(name = "children", nullable = false)
    private int numOfChildren;

    @Column(name = "total_guests", nullable = false)
    private int totalNumOfGuests;

    @Column(name = "confirmation_code", nullable = false, unique = true)
    private String bookingConfirmationCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    public void calculateTotalNumberOfGuests(){
        this.totalNumOfGuests = this.numOfAdults + this.numOfChildren;
    }

    public void setNumOfAdults(int numOfAdults) {
        this.numOfAdults = numOfAdults;
        calculateTotalNumberOfGuests();
    }

    public void setNumOfChildren(int numOfChildren) {
        this.numOfChildren = numOfChildren;
        calculateTotalNumberOfGuests();
    }
}