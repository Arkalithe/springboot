package fr.hbvt.springboot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(
        indexes = {@Index(columnList = "path")}
)
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String path;

    @Column(nullable = false, length = 12)
    @NotBlank
    private String extension;

    @ManyToOne()
    @JoinColumn(nullable = false)
    private Lodging lodging;

}
