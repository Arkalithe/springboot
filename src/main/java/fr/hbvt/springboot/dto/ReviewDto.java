package fr.hbvt.springboot.dto;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import fr.hbvt.springboot.jsonviews.ReviewJsonview;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonView(ReviewJsonview.showReviewSimple.class)
public class ReviewDto {
    @NotBlank
    @NotNull
    private String content;
    @NotBlank
    @NotNull
    private float rating;
    @NotBlank
    @NotNull
    private LocalDateTime date;

}
