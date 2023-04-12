package uk.co.bransbyhorses.equinetrainingtrackerapi.api.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "training_categories")
public class TrainingCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "training_category_id", nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;
}
