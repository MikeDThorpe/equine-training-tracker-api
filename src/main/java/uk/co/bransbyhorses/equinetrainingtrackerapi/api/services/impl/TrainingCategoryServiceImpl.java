package uk.co.bransbyhorses.equinetrainingtrackerapi.api.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.TrainingCategory;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.repositories.TrainingCategoryRepository;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.services.TrainingCategoryService;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TrainingCategoryServiceImpl implements TrainingCategoryService {

    @Autowired public final TrainingCategoryRepository repository;

    @Override
    public TrainingCategory getOneRecord(UUID id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<TrainingCategory> getAllRecords() {
        return repository.findAll();
    }

    @Override
    public TrainingCategory createRecord(TrainingCategory newRecord) {
        return repository.save(newRecord);
    }

    @Override
    public TrainingCategory updateRecord(TrainingCategory updatedRecord, UUID id) {
        TrainingCategory trainingCategory = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        trainingCategory.setName(updatedRecord.getName());
        return repository.save(trainingCategory);
    }

    @Override
    public void deleteRecord(UUID id) {
        TrainingCategory trainingCategory = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        repository.delete(trainingCategory);
    }
}
