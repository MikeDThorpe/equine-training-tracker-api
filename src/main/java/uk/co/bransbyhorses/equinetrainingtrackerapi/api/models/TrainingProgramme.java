package uk.co.bransbyhorses.equinetrainingtrackerapi.api.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "training_programmes")
public class TrainingProgramme {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "training_programme_id", nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "training_category_id", referencedColumnName = "training_category_id")
    private TrainingCategory trainingCategory;

    @ManyToOne
    @JoinColumn(name = "equine_id", referencedColumnName = "equine_id", nullable = false)
    private Equine equine;

    @Column(name = "start_date")
    private Timestamp startDate;

    @Column(name = "end_date")
    private Timestamp endDate;

    @CreatedBy
    @Column(name = "created_by", updatable = false)
    private String createdBy;

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdDate;
}
