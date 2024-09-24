package fr.hbvt.springboot.controller;

import fr.hbvt.springboot.dto.FavoriteDto;
import fr.hbvt.springboot.entity.Favorite;
import fr.hbvt.springboot.service.FavoriteService;
import fr.hbvt.springboot.jsonviews.FavoriteJsonview;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
@AllArgsConstructor
public class FavoriteController {

    private final FavoriteService favoriteService;

    @GetMapping
    @JsonView(FavoriteJsonview.showFavoriteSimple.class)
    public List<Favorite> getAllFavorite() {
        return favoriteService.list();
    }

    @GetMapping("/{id}")
    @JsonView(FavoriteJsonview.showFavoriteDetailed.class)
    public Favorite getFavoriteById(@PathVariable Long id) {
        return favoriteService.findById(id);
    }

    @PostMapping
    public Favorite create(@RequestBody FavoriteDto favoriteDto) {
        return favoriteService.create(favoriteDto);
    }

    @PutMapping("/{id}")
    public Favorite update(@PathVariable Long id, @RequestBody FavoriteDto favoriteDto) {
        return favoriteService.update(favoriteDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        favoriteService.delete(id);
    }
}
