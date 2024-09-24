package fr.hbvt.springboot.controller;

import fr.hbvt.springboot.dto.MediaDto;
import fr.hbvt.springboot.service.MediaService;
import fr.hbvt.springboot.jsonviews.MediaJsonview;
import fr.hbvt.springboot.entity.Media;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medias")
@AllArgsConstructor
public class MediaController {

    private final MediaService mediaService;

    @GetMapping
    @JsonView(MediaJsonview.showMediaSimple.class)
    public List<Media> getAllMedia() {
        return mediaService.list();
    }

    @GetMapping("/{id}")
    @JsonView(MediaJsonview.showMediaDetailed.class)
    public Media getMediaById(@PathVariable Long id) {
        return mediaService.findById(id);
    }

    @PostMapping
    public Media create(@RequestBody MediaDto mediaDto) {
        return mediaService.create(mediaDto);
    }

    @PutMapping("/{id}")
    public Media update(@PathVariable Long id, @RequestBody MediaDto mediaDto) {
        return mediaService.update(mediaDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        mediaService.delete(id);
    }
}
