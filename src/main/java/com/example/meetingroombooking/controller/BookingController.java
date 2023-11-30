package com.example.meetingroombooking.controller;

import com.example.meetingroombooking.entity.Booking;
//import com.example.meetingroombooking.entity.Cabin;
import com.example.meetingroombooking.entity.BookingRoomType;
import com.example.meetingroombooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

//    (API)get list of bookings by time

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<Void> createBooking(@RequestBody Booking booking) {
        bookingService.saveBooking(booking);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // start time , end time
    @GetMapping("/get")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    // getBooking

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        Booking booking = bookingService.getBookingById(id);
        if (booking != null) {
            return new ResponseEntity<>(booking, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Void> updateBooking(@PathVariable Long id, @RequestBody Booking booking) {
        Booking existingBooking = bookingService.getBookingById(id);
        if (existingBooking != null) {
            booking.setBookingId(id);
            bookingService.saveBooking(booking);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        Booking existingBooking = bookingService.getBookingById(id);
        if (existingBooking != null) {
            bookingService.deleteBooking(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{bookingId}/book")
    public ResponseEntity<Booking> bookRoom(@PathVariable Long bookingId, @RequestParam BookingRoomType roomType) {
        Booking bookedRoom = bookingService.bookRoom(bookingId, roomType);
        if (bookedRoom != null) {
            return new ResponseEntity<>(bookedRoom, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/booked")
    public ResponseEntity<List<Booking>> getBookedRooms() {
        List<Booking> bookedRooms = bookingService.getBookedRooms();
        return new ResponseEntity<>(bookedRooms, HttpStatus.OK);
    }

    @GetMapping("/byType")
    public ResponseEntity<List<Booking>> getBookingsByRoomType(@RequestParam BookingRoomType roomType) {
        List<Booking> bookingsByRoomType = bookingService.getBookingsByRoomType(roomType);
        return new ResponseEntity<>(bookingsByRoomType, HttpStatus.OK);
    }

    @GetMapping("/bookings")
    public List<Booking> getBookings(@RequestParam LocalDate bookingDate,
                                     @RequestParam LocalDateTime startTime,
                                     @RequestParam LocalDateTime endTime) {
        return bookingService.findByBookingDateAndTimeRange(bookingDate, startTime, endTime);
    }

}
