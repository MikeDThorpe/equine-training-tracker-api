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
    public TrainingEnvironment getTrainingEnvironment(UUID id) throws EntityNotFoundException {
        return trainingEnvironmentRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<TrainingEnvironment> getTrainingEnvironments() {
        return trainingEnvironmentRepository.findAll();
    }

    @Override
    public TrainingEnvironment createTrainingEnvironment(TrainingEnvironment trainingEnvironment) {
        return trainingEnvironmentRepository.save(trainingEnvironment);
    }

    @Override
    public TrainingEnvironment updateTrainingEnvironment(TrainingEnvironment trainingEnvironment) {
        return null;
    }

    @Override
    public void deleteTrainingEnvironment(UUID id) {
        trainingEnvironmentRepository.deleteById(id);
    }
}
