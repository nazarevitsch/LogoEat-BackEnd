package com.bida.logoeat.logoeat.web;

import com.bida.logoeat.logoeat.domain.Booking;
import com.bida.logoeat.logoeat.domain.Message;
import com.bida.logoeat.logoeat.service.BookingService;
import com.bida.logoeat.logoeat.service.dto.BookingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.Principal;
import java.util.List;

@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/booking")
    public ResponseEntity<Message> addBooking(@RequestBody BookingDTO bookingDTO, Principal principal) {
        bookingService.saveBooking(bookingDTO, principal.getName());
        bookingService.findAllByUserId(principal.getName());
        return new ResponseEntity(new Message("OK"), HttpStatus.OK);
    }

    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> getBookings(Principal principal) {
        return new ResponseEntity<>(bookingService.findAllByUserId(principal.getName()), HttpStatus.OK);
    }
}
