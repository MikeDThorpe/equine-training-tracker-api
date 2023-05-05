package uk.co.bransbyhorses.equinetrainingtrackerapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.Equine;

import java.util.UUID;

public interface EquineRepository extends JpaRepository<Equine, UUID> {
}
