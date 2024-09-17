package com.project.dverse.service;
import java.util.List;
import com.project.dverse.entity.BookingEntity;
public interface BookingInterface {
    List<BookingEntity> getAllBookings();
    BookingEntity getBookingById(Long id);
    BookingEntity createBooking(BookingEntity book, Long userId, Long movieId);
    BookingEntity updateBooking(Long id, BookingEntity booking);
    void deleteBooking(Long id);
}

