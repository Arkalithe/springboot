package fr.hbvt.springboot.dto;

import com.fasterxml.jackson.annotation.JsonView;
import fr.hbvt.springboot.entity.Address;
import fr.hbvt.springboot.jsonviews.LodgingJsonview;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonView(LodgingJsonview.showLodgingSimple.class)
public class LodgingUpdateDto {
    @NotBlank
    @NotNull
    private String name;

    private int capacity;

    private int nightPrice;

    private String description;

}
