package com.example.meetingroombooking.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Booking")
@Getter
@Setter
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @Column (name = "bookingDate")
    private LocalDate bookingDate;

    @Column (name = "startTime")
    private LocalDateTime startTime;

    @Column (name = "endTime")
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "booth1")
    private BookingRoomType booth1;

    @Enumerated(EnumType.STRING)
    @Column(name = "booth2")
    private BookingRoomType booth2;

    @Enumerated(EnumType.STRING)
    @Column(name = "four_seater")
    private BookingRoomType fourSeater;

    @Enumerated(EnumType.STRING)
    @Column(name = "six_seater")
    private BookingRoomType sixSeater;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> users;












}
