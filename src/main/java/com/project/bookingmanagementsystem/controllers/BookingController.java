package com.project.bookingmanagementsystem.controllers;

import Models.Booking;
import dtos.CreateBookingRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.BookingService;

@RestController

@RequestMapping("/api/v1")
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @PostMapping("/booking")
    public Booking createBooking(@RequestBody CreateBookingRequest request){
        return bookingService.createBooking(request);
    }
    @GetMapping ("/booking/b1")
    public String createBookings(){
        return "hey";
    }


}
