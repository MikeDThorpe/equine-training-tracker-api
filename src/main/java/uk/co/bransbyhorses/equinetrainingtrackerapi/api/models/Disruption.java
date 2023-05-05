package uk.co.bransbyhorses.equinetrainingtrackerapi.api.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.repository.Temporal;

import java.sql.Timestamp;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "disruptions")
public class Disruption {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "disruption_id", nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "equine_id", referencedColumnName = "equine_id")
    private Equine equine;

    @Column(name = "disruption_code")
    private DisruptionCode disruptionCode;

    @Column(name = "comment")
    private String comment;

    @Column(name = "start_date")
    private Timestamp startDate;

    @Column(name = "end_date")
    private Timestamp endDate;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;
}
