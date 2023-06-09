package uk.co.bransbyhorses.equinetrainingtrackerapi.api.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "training_environments")
public class TrainingEnvironment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "training_environment_id", nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;
}
