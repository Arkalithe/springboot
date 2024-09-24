package fr.hbvt.springboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(
        indexes = {@Index(columnList = "slug")}
)
public class Lodging {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int capacity;

    @Column(nullable = false)
    private boolean isAccessible;

    @Column(nullable = false)
    private int nightPrice;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private String slug;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "lodging")
    private List<Media> medias = new ArrayList<>();

    @OneToMany(mappedBy = "lodging")
    private List<Booking> bookings = new ArrayList<>();

    @OneToMany(mappedBy = "lodging")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "lodging")
    private List<Favorite> favorites = new ArrayList<>();

    @ManyToMany(mappedBy = "lodgings")
    private List<Room> rooms = new ArrayList<>();
}