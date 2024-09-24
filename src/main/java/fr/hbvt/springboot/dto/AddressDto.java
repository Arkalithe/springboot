package fr.hbvt.springboot.dto;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import fr.hbvt.springboot.jsonviews.AddressJsonview;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonView(AddressJsonview.showAddressSimple.class)
public class AddressDto {

    @NotBlank
    @NotNull
    private String street;

    private String number;

    @NotBlank
    @NotNull
    private String zipcode;

    @NotBlank
    @NotNull
    private String city;

    @NotBlank
    @NotNull
    private String country;

    @NotNull
    private float longitude;

    @NotNull
    private float latitude;

    private boolean isiBilled;

}
