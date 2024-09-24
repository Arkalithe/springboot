package fr.hbvt.springboot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressUpdateDto {

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

    private String more;
}
