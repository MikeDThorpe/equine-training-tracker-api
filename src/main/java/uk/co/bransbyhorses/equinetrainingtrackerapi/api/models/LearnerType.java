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
@Table(name = "learner_types")
public class LearnerType {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "learner_type_id", nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;
}
