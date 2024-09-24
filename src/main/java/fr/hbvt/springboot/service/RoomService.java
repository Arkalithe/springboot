package fr.hbvt.springboot.service;

import fr.hbvt.springboot.exception.CustomEntityNotFoundException;
import fr.hbvt.springboot.repository.RoomRepository;
import fr.hbvt.springboot.entity.Room;
import fr.hbvt.springboot.dto.RoomDto;
import fr.hbvt.springboot.service.interfaces.ServiceListInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoomService implements ServiceListInterface<Room, Long, RoomDto, RoomDto> {

    private final RoomRepository roomRepository;

    @Override
    public Room create(RoomDto roomDto) {
        return roomRepository.saveAndFlush(objectFromDto(new Room(), roomDto));
    }

    @Override
    public Room update(RoomDto roomDto, Long id) {
        Room room = objectFromDto(findById(id), roomDto);
        room.setId(id);
        roomRepository.flush();
        return room;
    }

    @Override
    public void delete(Long id) {
        roomRepository.deleteById(id);
    }

    @Override
    public Room findById(Long id) {
        return roomRepository.findById(id).orElseThrow(CustomEntityNotFoundException::new);
    }

    @Override
    public List<Room> list() {
        return roomRepository.findAll();
    }

    private Room objectFromDto(Room room, RoomDto roomDto) {

        //Faire les xxx.set(xxx.get());
        return room;
    }
}
