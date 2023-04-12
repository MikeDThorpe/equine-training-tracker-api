package uk.co.bransbyhorses.equinetrainingtrackerapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.Yard;

import java.util.UUID;

public interface YardRepository extends JpaRepository<Yard, UUID> {
}
