package fr.hbvt.springboot.controller;

import fr.hbvt.springboot.dto.ReviewDto;
import fr.hbvt.springboot.service.ReviewService;
import fr.hbvt.springboot.jsonviews.ReviewJsonview;
import fr.hbvt.springboot.entity.Review;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
@AllArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    @JsonView(ReviewJsonview.showReviewSimple.class)
    public List<Review> getAllReview() {
        return reviewService.list();
    }

    @GetMapping("/{id}")
    @JsonView(ReviewJsonview.showReviewDetailed.class)
    public Review getReviewById(@PathVariable Long id) {
        return reviewService.findById(id);
    }

    @PostMapping
    public Review create(@RequestBody ReviewDto reviewDto) {
        return reviewService.create(reviewDto);
    }

    @PutMapping("/{id}")
    public Review update(@PathVariable Long id, @RequestBody ReviewDto reviewDto) {
        return reviewService.update(reviewDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reviewService.delete(id);
    }
}
