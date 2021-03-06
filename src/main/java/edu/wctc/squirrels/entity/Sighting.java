package edu.wctc.squirrels.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Sighting")
public class Sighting {
    @Id
    @Column(name = "sighting_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "squirrel_id")
    private int squirrelId;

    @NotBlank
    @Column(name = "spotter_name")
    private String spotterName;

    //@Column(name = "location_id")
    //private int locationId;
    @ManyToOne
    @JoinColumn(name="location_id")
    private Location location;

    @Min(1)
    @Max(20)
    @Column(name = "count")
    private int count;

    @Column(name = "spotted_at")
    private LocalDateTime spottedAt;


    @Min(-60)
    @Max(130)
    @Column(name = "temperature")
    private int temperature;

    @PrePersist
    void spottedAt() {
        this.spottedAt = LocalDateTime.now();
    }
}
