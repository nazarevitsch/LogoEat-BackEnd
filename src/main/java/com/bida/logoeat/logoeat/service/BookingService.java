package com.bida.logoeat.logoeat.service;

import com.bida.logoeat.logoeat.domain.Booking;
import com.bida.logoeat.logoeat.domain.User;
import com.bida.logoeat.logoeat.repository.BookingRepository;
import com.bida.logoeat.logoeat.service.dto.BookingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserService userService;

    public void saveBooking(BookingDTO bookingDTO, String email){
        User user = userService.findUserByEmail(email);

        Booking booking = new Booking();
        booking.setBookingDate(new Timestamp(bookingDTO.getBookingDate()));
        booking.setUserId(user.getId());
        booking.setRestaurantId(bookingDTO.getRestaurantId());
        booking.setPeopleAmount(bookingDTO.getPeopleAmount());
        booking.setUserName(bookingDTO.getUserName());

        bookingRepository.save(booking);
    }

    public List<Booking> findAllByUserId(String email) {
        return bookingRepository.findAllByUserId(userService.findUserByEmail(email).getId());
    }
}
