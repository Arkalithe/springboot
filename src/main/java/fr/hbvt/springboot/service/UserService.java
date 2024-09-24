package fr.hbvt.springboot.service;

import fr.hbvt.springboot.repository.UserRepository;
import fr.hbvt.springboot.entity.User;
import fr.hbvt.springboot.dto.UserDto;
import fr.hbvt.springboot.service.interfaces.ServiceListInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService implements ServiceListInterface<User, String, UserDto, UserDto> {

    private final UserRepository userRepository;

    @Override
    public User create(UserDto userDto) {
        return userRepository.saveAndFlush(objectFromDto(new User(), userDto));
    }

    @Override
    public User update(UserDto userDto, String id) {
        User user = objectFromDto(findById(id), userDto);
        user.setUuid(id);
        userRepository.flush();
        return user;
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    private User objectFromDto(User user, UserDto userDto) {

        //Faire les xxx.set(xxx.get());
        return user;
    }
}
