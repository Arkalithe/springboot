package fr.hbvt.springboot.service;

import fr.hbvt.springboot.exception.CustomEntityNotFoundException;
import fr.hbvt.springboot.repository.MediaRepository;
import fr.hbvt.springboot.entity.Media;
import fr.hbvt.springboot.dto.MediaDto;
import fr.hbvt.springboot.service.interfaces.ServiceListInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MediaService implements ServiceListInterface<Media, Long, MediaDto, MediaDto>{
   
    private final MediaRepository mediaRepository;
    
    @Override
    public Media create(MediaDto mediaDto) {
    return mediaRepository.saveAndFlush(objectFromDto(new Media(),mediaDto));
    }
    
    @Override
    public Media update(MediaDto mediaDto, Long id) {
    Media media = objectFromDto(findById(id), mediaDto);
    media.setId(id);
    mediaRepository.flush();
    return media;
    }

    @Override
    public void delete(Long id) {
    mediaRepository.deleteById(id);
    }
    
    @Override
    public Media findById(Long id) {
    return mediaRepository.findById(id).orElseThrow(CustomEntityNotFoundException::new);
    }
    
    @Override
    public List<Media> list() {
    return mediaRepository.findAll();
    }
    
    private Media objectFromDto(Media media,MediaDto mediaDto) {
   
    //Faire les xxx.set(xxx.get());
    return media;
    }
}
