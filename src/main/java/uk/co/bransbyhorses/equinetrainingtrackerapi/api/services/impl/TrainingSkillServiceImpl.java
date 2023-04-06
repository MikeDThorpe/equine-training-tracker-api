package uk.co.bransbyhorses.equinetrainingtrackerapi.api.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.TrainingSkill;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.repositories.TrainingSkillRepository;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.services.TrainingSkillService;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TrainingSkillServiceImpl implements TrainingSkillService {

    private final TrainingSkillRepository repository;

    @Override
    public TrainingSkill getOneRecord(UUID id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<TrainingSkill> getAllRecords(UUID id) {
        return repository.findAll();
    }

    @Override
    public TrainingSkill createRecord(TrainingSkill newRecord) {
        return repository.save(newRecord);
    }

    @Override
    public TrainingSkill updateRecord(TrainingSkill updatedTrainingSkill, UUID id) {
        TrainingSkill trainingSkill = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        trainingSkill.setName(updatedTrainingSkill.getName());
        return repository.save(trainingSkill);
    }

    @Override
    public void deleteRecord(UUID id) {
        TrainingSkill trainingSkill = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        repository.delete(trainingSkill);
    }
}
