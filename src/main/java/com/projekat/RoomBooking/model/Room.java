package com.projekat.RoomBooking.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_seq")
    @SequenceGenerator(name = "room_seq", sequenceName = "room_sequence", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String roomType;

    @Column(nullable = false)
    private BigDecimal roomPrice;

    @Column(name = "is_booked", nullable = false)
    private boolean isBooked = false;

    @Lob
    @Column(columnDefinition = "bytea")
    private byte[] photo;

    @OneToMany(mappedBy="room", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BookedRoom> bookings = new ArrayList<>();

    public Room() {}

    public void addBooking(BookedRoom booking){
        bookings.add(booking);
        booking.setRoom(this);
        isBooked = true;
        booking.setBookingConfirmationCode(RandomStringUtils.randomNumeric(10));
    }
}