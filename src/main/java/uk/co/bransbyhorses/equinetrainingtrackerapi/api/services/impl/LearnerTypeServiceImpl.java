package uk.co.bransbyhorses.equinetrainingtrackerapi.api.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.LearnerType;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.repositories.LearnerTypeRepository;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.services.LearnerTypeService;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class LearnerTypeServiceImpl implements LearnerTypeService {

    private final LearnerTypeRepository repository;

    @Override
    public LearnerType getLearnerType(UUID id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<LearnerType> getLearnerTypes() {
        return repository.findAll();
    }

    @Override
    public LearnerType createLearnerType(LearnerType learnerType) {
        return repository.save(learnerType);
    }

    @Override
    public LearnerType updateLearnerType(UUID id, LearnerType updatedLearnerType) {
        LearnerType learnerTypeToUpdate = repository.findById(updatedLearnerType.getId())
                .orElseThrow(EntityNotFoundException::new);
        learnerTypeToUpdate.setName(updatedLearnerType.getName());
        return repository.save(learnerTypeToUpdate);
    }

    @Override
    public void deleteLearnerType(UUID id) {
        LearnerType learnerType = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        repository.delete(learnerType);
    }
}
