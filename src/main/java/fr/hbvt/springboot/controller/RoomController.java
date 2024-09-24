package fr.hbvt.springboot.controller;

import fr.hbvt.springboot.dto.RoomDto;
import fr.hbvt.springboot.service.RoomService;
import fr.hbvt.springboot.jsonviews.RoomJsonview;
import fr.hbvt.springboot.entity.Room;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rooms")
@AllArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    @JsonView(RoomJsonview.showRoomSimple.class)
    public List<Room> getAllRoom() {
        return roomService.list();
    }

    @GetMapping("/{id}")
    @JsonView(RoomJsonview.showRoomDetailed.class)
    public Room getRoomById(@PathVariable Long id) {
        return roomService.findById(id);
    }

    @PostMapping
    public Room create(@RequestBody RoomDto roomDto) {
        return roomService.create(roomDto);
    }

    @PutMapping("/{id}")
    public Room update(@PathVariable Long id, @RequestBody RoomDto roomDto) {
        return roomService.update(roomDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        roomService.delete(id);
    }
}
