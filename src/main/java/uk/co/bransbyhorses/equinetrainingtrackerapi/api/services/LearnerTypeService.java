package uk.co.bransbyhorses.equinetrainingtrackerapi.api.services;

import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.LearnerType;

import java.util.List;
import java.util.UUID;

public interface LearnerTypeService {

    LearnerType getLearnerType(UUID id);

    List<LearnerType> getLearnerTypes();

    LearnerType createLearnerType(LearnerType learnerType);

    LearnerType updateLearnerType(UUID id, LearnerType learnerType);

    void deleteLearnerType(UUID id);
}
