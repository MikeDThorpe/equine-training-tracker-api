package uk.co.bransbyhorses.equinetrainingtrackerapi.api.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "equines")
public class Equine {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "equine_id", nullable = false)
    private UUID id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "yard_id", referencedColumnName = "yard_id")
    private Yard yard;

    @Column(name = "equine_status")
    private EquineStatus equineStatus;

    @ManyToOne
    @JoinColumn(name = "learner_type_id", referencedColumnName = "learner_type_id")
    private LearnerType learnerType;
}
