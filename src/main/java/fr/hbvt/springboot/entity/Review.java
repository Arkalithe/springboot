package fr.hbvt.springboot.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private float rating;

    @Column(nullable = false)
    private LocalDateTime date;

    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false)
    private Lodging lodging;

    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;

}