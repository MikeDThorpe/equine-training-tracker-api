package uk.co.bransbyhorses.equinetrainingtrackerapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.TrainingSkill;

import java.util.UUID;

public interface TrainingSkillRepository extends JpaRepository<TrainingSkill, UUID> {
}
