package fr.hbvt.springboot.dto;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import fr.hbvt.springboot.jsonviews.BookingJsonview;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonView(BookingJsonview.showBookingSimple.class)
public class BookingDto {

    @NotBlank
    @NotNull
    private int quantity;
}
