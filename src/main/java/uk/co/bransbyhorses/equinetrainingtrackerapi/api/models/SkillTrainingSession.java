package uk.co.bransbyhorses.equinetrainingtrackerapi.api.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "skill_training_sessions")
public class SkillTrainingSession {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "training_programme", referencedColumnName = "training_programme_id", nullable = false)
    private TrainingProgramme trainingProgramme;

    @ManyToOne
    @JoinColumn(name = "skill", referencedColumnName = "training_skill_id", nullable = false)
    private TrainingSkill skill;

    @ManyToOne
    @JoinColumn(name = "training_method", referencedColumnName = "training_method_id", nullable = false)
    private TrainingMethod trainingMethod;

    @ManyToOne
    @JoinColumn(name = "training_environment", referencedColumnName = "training_environment_id", nullable = false)
    private TrainingEnvironment trainingEnvironment;

    @Column(name = "progress_code", nullable = false)
    @Enumerated
    private ProgressCode progressCode;

    @Column(name = "training_time_in_minutes", nullable = false)
    private Long trainingTimeInMinutes;

    @Column(name = "notes")
    private String notes;

    @CreatedBy
    @Column(name = "created_by", updatable = false)
    private String createdBy;

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdDate;
}