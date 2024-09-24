package fr.hbvt.springboot.dto;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import fr.hbvt.springboot.jsonviews.MediaJsonview;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonView(MediaJsonview.showMediaSimple.class)
public class MediaDto {
    @NotBlank
    @NotNull
    private String path;
    @NotBlank
    @NotNull
    private String extension;
}
