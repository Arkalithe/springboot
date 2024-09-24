package fr.hbvt.springboot.controller;

import fr.hbvt.springboot.dto.UserDto;
import fr.hbvt.springboot.service.UserService;
import fr.hbvt.springboot.jsonviews.UserJsonview;
import fr.hbvt.springboot.entity.User;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    @JsonView(UserJsonview.showUserSimple.class)
    public List<User> getAllUser() {
        return userService.list();
    }

    @GetMapping("/{id}")
    @JsonView(UserJsonview.showUserDetailed.class)
    public User getUserById(@PathVariable String id) {
        return userService.findById(id);
    }

    @PostMapping
    public User create(@RequestBody UserDto userDto) {
        return userService.create(userDto);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable String id, @RequestBody UserDto userDto) {
        return userService.update(userDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        userService.delete(id);
    }
}
