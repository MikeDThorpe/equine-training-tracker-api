package uk.co.bransbyhorses.equinetrainingtrackerapi.mappers;

import org.mapstruct.Mapper;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.LearnerType;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.dto.LearnerTypeDto;

@Mapper(componentModel = "spring")
public interface LearnerTypeMapper {

    LearnerTypeDto mapToDto(LearnerType learnerType);

    LearnerType mapToEntity(LearnerTypeDto learnerType);
}
