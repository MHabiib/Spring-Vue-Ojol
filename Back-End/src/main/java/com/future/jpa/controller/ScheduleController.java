package com.future.jpa.controller;

import com.future.jpa.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.time.Instant;
import java.util.concurrent.ScheduledFuture;
@CrossOrigin
@Controller
@Configuration
@EnableAsync
@EnableScheduling
public class ScheduleController {

    @Autowired
    TaskScheduler taskScheduler;
    @Autowired
    BookingController bookingController;

    ScheduledFuture<?> scheduledFuture;

    @PostMapping("/start")
    ResponseEntity<Void> start(@RequestBody Booking booking) {
        int FIXED_RATE=86400000;

        scheduledFuture = taskScheduler.scheduleAtFixedRate(createSchedule(booking), FIXED_RATE);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/stop")
    ResponseEntity<Void> stop() {
        scheduledFuture.cancel(false);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private Runnable createSchedule(@RequestBody Booking booking) {
        return () -> bookingController.createBooking(booking);
    }
}