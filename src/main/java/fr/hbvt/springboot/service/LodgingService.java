package fr.hbvt.springboot.service;

import fr.hbvt.springboot.exception.CustomEntityNotFoundException;
import fr.hbvt.springboot.repository.LodgingRepository;
import fr.hbvt.springboot.entity.Lodging;
import fr.hbvt.springboot.dto.LodgingDto;
import fr.hbvt.springboot.service.interfaces.ServiceListInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LodgingService implements ServiceListInterface<Lodging, String, LodgingDto, LodgingDto> {

    private final LodgingRepository lodgingRepository;

    @Override
    public Lodging create(LodgingDto lodgingDto) {
        return lodgingRepository.saveAndFlush(objectFromDto(new Lodging(), lodgingDto));
    }

    @Override
    public Lodging update(LodgingDto lodgingDto, String id) {
        Lodging lodging = objectFromDto(findById(id), lodgingDto);
        lodging.setUuid(id);
        lodgingRepository.flush();
        return lodging;
    }

    @Override
    public void delete(String id) {
        lodgingRepository.deleteById(id);
    }

    @Override
    public Lodging findById(String id) {
        return lodgingRepository.findById(id).orElseThrow(CustomEntityNotFoundException::new);
    }

    @Override
    public List<Lodging> list() {
        return lodgingRepository.findAll();
    }

    private Lodging objectFromDto(Lodging lodging, LodgingDto lodgingDto) {

        //Faire les xxx.set(xxx.get());
        return lodging;
    }
}
