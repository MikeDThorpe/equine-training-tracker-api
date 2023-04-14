package uk.co.bransbyhorses.equinetrainingtrackerapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.TrainingEnvironment;

import java.util.UUID;

@Repository
public interface TrainingEnvironmentRepository extends JpaRepository<TrainingEnvironment, UUID> {
}
