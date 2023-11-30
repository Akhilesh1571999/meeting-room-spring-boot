package com.example.meetingroombooking.service;

import com.example.meetingroombooking.entity.Booking;
//import com.example.meetingroombooking.entity.Cabin;
import com.example.meetingroombooking.entity.BookingRoomType;
import com.example.meetingroombooking.repository.BookingRepository;
//import com.example.meetingroombooking.repository.CabinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

//    private final CabinRepository cabinRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public void saveBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    public Booking bookRoom(Long bookingId, BookingRoomType roomType) {
        Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);

        if (optionalBooking.isPresent()) {
            Booking booking = optionalBooking.get();

            switch (roomType) {
                case BOOTH1:
                    if (booking.getBooth1() == BookingRoomType.AVAILABLE) {
                        booking.setBooth1(BookingRoomType.BOOKED);
                        return bookingRepository.save(booking);
                    }
                    break;
                case BOOTH2:
                    if (booking.getBooth2() == BookingRoomType.AVAILABLE) {
                        booking.setBooth2(BookingRoomType.BOOKED);
                        return bookingRepository.save(booking);
                    }
                    break;
                case FOUR_SEATER_ROOM:
                    if (booking.getFourSeater() == BookingRoomType.AVAILABLE) {
                        booking.setFourSeater(BookingRoomType.BOOKED);
                        return bookingRepository.save(booking);
                    }
                    break;
                case SIX_SEATER_ROOM:
                    if (booking.getSixSeater() == BookingRoomType.AVAILABLE) {
                        booking.setSixSeater(BookingRoomType.BOOKED);
                        return bookingRepository.save(booking);
                    }
                    break;
            }
        }
        return null;
    }

    public List<Booking> getBookedRooms() {
        return bookingRepository.findAll().stream()
                .filter(booking -> booking.getBooth1() == BookingRoomType.BOOKED
                        || booking.getBooth2() == BookingRoomType.BOOKED
                        || booking.getFourSeater() == BookingRoomType.BOOKED)
                .collect(Collectors.toList());
    }

    public List<Booking> getBookingsByRoomType(BookingRoomType roomType) {
        return bookingRepository.findAll().stream()
                .filter(booking -> booking.getBooth1() == roomType
                        || booking.getBooth2() == roomType
                        || booking.getFourSeater() == roomType)
                .collect(Collectors.toList());
    }
}
