//package com.example.meetingroombooking.entity;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "Cabin")
//@Getter
//@Setter
//@Embeddable
//public class Cabin {
//    // to-do  cabin1 , cabin2 , cabin3
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long bookingId;
//
//    @Column(name = "cabin_name")
//
//    private boolean booth1;
//
//    private boolean booth2;
//
//    private boolean four_seater;
//
//
//    @OneToMany(mappedBy = "cabin")
//    private List<Booking> bookings;
//}
