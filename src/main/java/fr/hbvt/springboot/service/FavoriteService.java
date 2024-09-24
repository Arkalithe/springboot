package fr.hbvt.springboot.service;

import fr.hbvt.springboot.repository.FavoriteRepository;
import fr.hbvt.springboot.entity.Favorite;
import fr.hbvt.springboot.dto.FavoriteDto;
import fr.hbvt.springboot.service.interfaces.ServiceListInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FavoriteService implements ServiceListInterface<Favorite, Long, FavoriteDto, FavoriteDto>{
   
    private final FavoriteRepository favoriteRepository;
    
    @Override
    public Favorite create(FavoriteDto favoriteDto) {
    return favoriteRepository.saveAndFlush(objectFromDto(new Favorite(),favoriteDto));
    }
    
    @Override
    public Favorite update(FavoriteDto favoriteDto, Long id) {
    Favorite favorite = objectFromDto(findById(id), favoriteDto);
    favorite.setId(id);
    favoriteRepository.flush();
    return favorite;
    }

    @Override
    public void delete(Long id) {
    favoriteRepository.deleteById(id);
    }
    
    @Override
    public Favorite findById(Long id) {
    return favoriteRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    
    @Override
    public List<Favorite> list() {
    return favoriteRepository.findAll();
    }
    
    private Favorite objectFromDto(Favorite favorite,FavoriteDto favoriteDto) {
   
    //Faire les xxx.set(xxx.get());
    return favorite;
    }
}
