package fr.hbvt.springboot.dto;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Column;
import lombok.*;
import fr.hbvt.springboot.jsonviews.FavoriteJsonview;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonView(FavoriteJsonview.showFavoriteSimple.class)
public class FavoriteDto {

    private Long id;

}
