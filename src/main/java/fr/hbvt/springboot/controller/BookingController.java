package fr.hbvt.springboot.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.hbvt.springboot.dto.BookingDto;
import fr.hbvt.springboot.entity.Booking;
import fr.hbvt.springboot.service.BookingService;
import fr.hbvt.springboot.jsonviews.BookingJsonview;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/bookings")
@AllArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @GetMapping
    @JsonView(BookingJsonview.showBookingSimple.class)
    public List<Booking> getAllBooking() {
        return bookingService.list();
    }

    @GetMapping("/{id}")
    @JsonView(BookingJsonview.showBookingDetailed.class)
    public Booking getBookingById(@PathVariable String id) {
        return bookingService.findById(id);
    }

    @PostMapping
    public Booking create(@RequestBody BookingDto bookingDto) {
        return bookingService.create(bookingDto);
    }

    @PutMapping("/{id}")
    public Booking update(@PathVariable String id, @RequestBody BookingDto bookingDto) {
        return bookingService.update(bookingDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        bookingService.delete(id);
    }
}
