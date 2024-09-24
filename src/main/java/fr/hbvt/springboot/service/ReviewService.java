package fr.hbvt.springboot.service;

import fr.hbvt.springboot.exception.CustomEntityNotFoundException;
import fr.hbvt.springboot.repository.ReviewRepository;
import fr.hbvt.springboot.entity.Review;
import fr.hbvt.springboot.dto.ReviewDto;
import fr.hbvt.springboot.service.interfaces.ServiceListInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReviewService implements ServiceListInterface<Review, Long, ReviewDto, ReviewDto> {

    private final ReviewRepository reviewRepository;

    @Override
    public Review create(ReviewDto reviewDto) {
        return reviewRepository.saveAndFlush(objectFromDto(new Review(), reviewDto));
    }

    @Override
    public Review update(ReviewDto reviewDto, Long id) {
        Review review = objectFromDto(findById(id), reviewDto);
        review.setId(id);
        reviewRepository.flush();
        return review;
    }

    @Override
    public void delete(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public Review findById(Long id) {
        return reviewRepository.findById(id).orElseThrow(CustomEntityNotFoundException::new);
    }

    @Override
    public List<Review> list() {
        return reviewRepository.findAll();
    }

    private Review objectFromDto(Review review, ReviewDto reviewDto) {

        //Faire les xxx.set(xxx.get());
        return review;
    }
}
