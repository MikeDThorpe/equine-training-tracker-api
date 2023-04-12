package uk.co.bransbyhorses.equinetrainingtrackerapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.TrainingMethod;

import java.util.UUID;

public interface TrainingMethodRepository extends JpaRepository<TrainingMethod, UUID> {
}
