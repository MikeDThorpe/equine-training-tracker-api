package uk.co.bransbyhorses.equinetrainingtrackerapi.api.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "yards")
public class Yard {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "yard_id", nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;
}
