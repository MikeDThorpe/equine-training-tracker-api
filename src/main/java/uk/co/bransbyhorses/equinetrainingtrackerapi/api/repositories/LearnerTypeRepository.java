package uk.co.bransbyhorses.equinetrainingtrackerapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.LearnerType;

import java.util.UUID;

public interface LearnerTypeRepository extends JpaRepository<LearnerType, UUID> {
}
