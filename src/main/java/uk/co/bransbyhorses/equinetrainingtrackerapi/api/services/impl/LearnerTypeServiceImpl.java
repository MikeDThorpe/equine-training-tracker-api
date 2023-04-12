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
    public LearnerType getOneRecord(UUID id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<LearnerType> getAllRecords() {
        return repository.findAll();
    }

    @Override
    public LearnerType createRecord(LearnerType learnerType) {
        return repository.save(learnerType);
    }

    @Override
    public LearnerType updateRecord(LearnerType updatedLearnerType, UUID id) {
        LearnerType learnerTypeToUpdate = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        learnerTypeToUpdate.setName(updatedLearnerType.getName());
        return repository.save(learnerTypeToUpdate);
    }

    @Override
    public void deleteRecord(UUID id) {
        LearnerType learnerType = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        repository.delete(learnerType);
    }
}
