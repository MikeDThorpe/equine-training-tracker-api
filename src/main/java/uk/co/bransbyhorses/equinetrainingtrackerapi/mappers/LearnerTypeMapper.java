package uk.co.bransbyhorses.equinetrainingtrackerapi.mappers;

import org.mapstruct.Mapper;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.LearnerType;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.dto.LearnerTypeDto;

@Mapper(componentModel = "spring")
public interface LearnerTypeMapper extends ModelMapper<LearnerType, LearnerTypeDto> {
}
