package uk.co.bransbyhorses.equinetrainingtrackerapi.api.services;

import jakarta.persistence.EntityNotFoundException;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.TrainingEnvironment;

import java.util.List;
import java.util.UUID;

public interface TrainingEnvironmentService {

    TrainingEnvironment getTrainingEnvironment(UUID id) throws EntityNotFoundException;

    List<TrainingEnvironment> getTrainingEnvironments();

    TrainingEnvironment createTrainingEnvironment(TrainingEnvironment trainingEnvironment);

    TrainingEnvironment updateTrainingEnvironment(TrainingEnvironment trainingEnvironment);

    void deleteTrainingEnvironment(UUID id);
}
