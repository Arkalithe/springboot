package fr.hbvt.springboot.dto;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import fr.hbvt.springboot.jsonviews.RoomJsonview;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonView(RoomJsonview.showRoomSimple.class)
public class RoomDto {
    @NotBlank
    @NotNull
    private String type;
}
