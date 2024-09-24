package fr.hbvt.springboot.dto;

import com.fasterxml.jackson.annotation.JsonView;
import fr.hbvt.springboot.entity.Address;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import fr.hbvt.springboot.jsonviews.LodgingJsonview;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonView(LodgingJsonview.showLodgingSimple.class)
public class LodgingDto {
    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    private int capacity;

    private int nightPrice;

    private String description;

    @NotBlank
    @NotNull
    private AddressDto addressDto;
}
