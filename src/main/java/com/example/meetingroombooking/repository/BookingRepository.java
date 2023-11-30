package com.example.meetingroombooking.repository;

import com.example.meetingroombooking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    // finding meeting by date start time and end time

//    List<Meeting> findByMeetingDate(LocalDate meetingDate, LocalDateTime startTime, LocalDateTime endTime);

        @Query("SELECT b FROM Booking b WHERE b.bookingDate = :bookingDate AND b.startTime >= :startTime AND b.endTime <= :endTime")
        List<Booking> findByBookingDateAndTimeRange(
                @Param("bookingDate") LocalDate bookingDate,
                @Param("startTime") LocalDateTime startTime,
                @Param("endTime") LocalDateTime endTime
        );

        List<Booking> findByBookingDate(LocalDate bookingDate);
}

