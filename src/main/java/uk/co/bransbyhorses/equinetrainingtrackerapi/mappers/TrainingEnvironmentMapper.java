package uk.co.bransbyhorses.equinetrainingtrackerapi.mappers;

import org.hibernate.annotations.Comment;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.TrainingEnvironment;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.dto.TrainingEnvironmentDto;

@Mapper(componentModel = "spring")
public interface TrainingEnvironmentMapper {

    TrainingEnvironmentDto mapToDto(TrainingEnvironment trainingEnvironment);

    TrainingEnvironment mapToEntity(TrainingEnvironmentDto trainingEnvironment);
}
