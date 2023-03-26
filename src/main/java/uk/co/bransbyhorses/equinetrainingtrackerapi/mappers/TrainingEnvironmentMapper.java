package uk.co.bransbyhorses.equinetrainingtrackerapi.mappers;

import org.mapstruct.Mapper;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.TrainingEnvironment;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.dto.TrainingEnvironmentDto;

@Mapper
public interface TrainingEnvironmentMapper {

    TrainingEnvironmentDto mapToDto(TrainingEnvironment trainingEnvironment);

    TrainingEnvironment mapToEntity(TrainingEnvironmentDto trainingEnvironment);
}
