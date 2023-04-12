package uk.co.bransbyhorses.equinetrainingtrackerapi.api.services;

import jakarta.persistence.EntityNotFoundException;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.TrainingEnvironment;

import java.util.List;
import java.util.UUID;

public interface TrainingEnvironmentService extends ApiCrudService<TrainingEnvironment> {
}
