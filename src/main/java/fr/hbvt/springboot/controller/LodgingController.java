package fr.hbvt.springboot.controller;

import fr.hbvt.springboot.dto.LodgingDto;
import fr.hbvt.springboot.service.LodgingService;
import fr.hbvt.springboot.jsonviews.LodgingJsonview;
import fr.hbvt.springboot.entity.Lodging;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lodgings")
@AllArgsConstructor
public class LodgingController {

    private final LodgingService lodgingService;

    @GetMapping
    @JsonView(LodgingJsonview.showLodgingSimple.class)
    public List<Lodging> getAllLodging() {
        return lodgingService.list();
    }

    @GetMapping("/{id}")
    @JsonView(LodgingJsonview.showLodgingDetailed.class)
    public Lodging getLodgingById(@PathVariable String id) {
        return lodgingService.findById(id);
    }

    @PostMapping
    public Lodging create(@RequestBody LodgingDto lodgingDto) {
        return lodgingService.create(lodgingDto);
    }

    @PutMapping("/{id}")
    public Lodging update(@PathVariable String id, @RequestBody LodgingDto lodgingDto) {
        return lodgingService.update(lodgingDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        lodgingService.delete(id);
    }
}
