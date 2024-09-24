package fr.hbvt.springboot.service;

import fr.hbvt.springboot.repository.BookingRepository;
import fr.hbvt.springboot.entity.Booking;
import fr.hbvt.springboot.dto.BookingDto;
import fr.hbvt.springboot.service.interfaces.ServiceListInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookingService implements ServiceListInterface<Booking, String, BookingDto, BookingDto>{
   
    private final BookingRepository bookingRepository;
    
    @Override
    public Booking create(BookingDto bookingDto) {
    return bookingRepository.saveAndFlush(objectFromDto(new Booking(),bookingDto));
    }
    
    @Override
    public Booking update(BookingDto bookingDto, String id) {
    Booking booking = objectFromDto(findById(id), bookingDto);
    booking.setUuid(id);
    bookingRepository.flush();
    return booking;
    }

    @Override
    public void delete(String id) {
    bookingRepository.deleteById(id);
    }
    
    @Override
    public Booking findById(String id) {
    return bookingRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    
    @Override
    public List<Booking> list() {
    return bookingRepository.findAll();
    }
    
    private Booking objectFromDto(Booking booking,BookingDto bookingDto) {
   
    //Faire les xxx.set(xxx.get());
    return booking;
    }
}
