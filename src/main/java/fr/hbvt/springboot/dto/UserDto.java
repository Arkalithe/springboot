package fr.hbvt.springboot.dto;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import fr.hbvt.springboot.jsonviews.UserJsonview;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonView(UserJsonview.showUserSimple.class)
public class UserDto {

    @NotBlank
    @NotNull
    private String firstname;

    @NotBlank
    @NotNull
    private String lastname;

    @NotBlank
    @NotNull
    private String email;

    @NotBlank
    @NotNull
    private String password;

    @NotBlank
    @NotNull
    private LocalDate birthAth;

    @NotBlank
    @NotNull
    private LocalDateTime createdAt;

}
