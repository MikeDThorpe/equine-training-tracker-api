package uk.co.bransbyhorses.equinetrainingtrackerapi.api.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.TrainingEnvironment;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.repositories.TrainingEnvironmentRepository;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.services.TrainingEnvironmentService;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class TrainingEnvironmentServiceImpl implements TrainingEnvironmentService {

    @Autowired
    private final TrainingEnvironmentRepository trainingEnvironmentRepository;

    @Override
    public TrainingEnvironment getOneRecord(UUID id) throws EntityNotFoundException {
        return trainingEnvironmentRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<TrainingEnvironment> getAllRecords() {
        return trainingEnvironmentRepository.findAll();
    }

    @Override
    public TrainingEnvironment createRecord(TrainingEnvironment trainingEnvironment) {
        return trainingEnvironmentRepository.save(trainingEnvironment);
    }

    @Override
    public TrainingEnvironment updateRecord(TrainingEnvironment updatedTrainingEnvironment, UUID id) {
        TrainingEnvironment trainingEnvironmentToUpdate = trainingEnvironmentRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        trainingEnvironmentToUpdate.setName(updatedTrainingEnvironment.getName());
        return trainingEnvironmentRepository.save(trainingEnvironmentToUpdate);
    }

    @Override
    public void deleteRecord(UUID id) {
        trainingEnvironmentRepository.deleteById(id);
    }
}
