package fr.hbvt.springboot.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDto {

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

    private LocalDateTime updatedAt;
}
