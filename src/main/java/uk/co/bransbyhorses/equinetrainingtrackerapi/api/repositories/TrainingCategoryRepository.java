package uk.co.bransbyhorses.equinetrainingtrackerapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.TrainingCategory;

import java.util.UUID;

public interface TrainingCategoryRepository extends JpaRepository<TrainingCategory, UUID> {
}
