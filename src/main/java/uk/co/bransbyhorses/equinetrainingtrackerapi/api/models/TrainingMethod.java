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
@Table(name = "training_methods")
public class TrainingMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "training_methods_id", nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;
}
