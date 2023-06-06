package uk.co.bransbyhorses.equinetrainingtrackerapi.api.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.TrainingProgramme;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.repositories.TrainingProgrammeRepository;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.services.TrainingProgrammeService;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class TrainingProgrammeServiceImpl implements TrainingProgrammeService {

    private final TrainingProgrammeRepository repository;

    @Override
    public TrainingProgramme getOneRecord(UUID id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<TrainingProgramme> getAllRecords() {
        return repository.findAll();
    }

    @Override
    public TrainingProgramme createRecord(TrainingProgramme newRecord) {
        return repository.save(newRecord);
    }

    @Override
    public TrainingProgramme updateRecord(TrainingProgramme updatedRecord, UUID id) {
        TrainingProgramme trainingProgramme = repository.findById(updatedRecord.getId())
                .orElseThrow(EntityNotFoundException::new);
        trainingProgramme.setTrainingCategory(updatedRecord.getTrainingCategory());
        trainingProgramme.setEquine(updatedRecord.getEquine());
        trainingProgramme.setStartDate(updatedRecord.getStartDate());
        trainingProgramme.setEndDate(updatedRecord.getEndDate());
        trainingProgramme.setCreatedBy(updatedRecord.getCreatedBy());
        trainingProgramme.setCreatedDate(updatedRecord.getCreatedDate());
        return repository.save(trainingProgramme);
    }

    @Override
    public void deleteRecord(UUID id) {
        TrainingProgramme trainingProgramme = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        repository.delete(trainingProgramme);
    }
}
