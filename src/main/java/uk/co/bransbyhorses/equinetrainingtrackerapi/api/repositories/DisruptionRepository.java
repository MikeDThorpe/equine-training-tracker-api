package uk.co.bransbyhorses.equinetrainingtrackerapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.Disruption;

import java.util.UUID;

public interface DisruptionRepository extends JpaRepository<Disruption, UUID> {
}
