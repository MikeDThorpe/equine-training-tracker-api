package uk.co.bransbyhorses.equinetrainingtrackerapi.api.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.TrainingMethod;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.repositories.TrainingMethodRepository;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.services.TrainingMethodService;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TrainingMethodServiceImpl implements TrainingMethodService {

    private final TrainingMethodRepository repository;

    @Override
    public TrainingMethod getOneRecord(UUID id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<TrainingMethod> getAllRecords() {
        return repository.findAll();
    }

    @Override
    public TrainingMethod createRecord(TrainingMethod newRecord) {
        return repository.save(newRecord);
    }

    @Override
    public TrainingMethod updateRecord(TrainingMethod updatedRecord, UUID id) {
        TrainingMethod trainingMethod = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        trainingMethod.setName(updatedRecord.getName());
        return repository.save(trainingMethod);
    }

    @Override
    public void deleteRecord(UUID id) {
        TrainingMethod trainingMethod = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        repository.delete(trainingMethod);
    }
}
