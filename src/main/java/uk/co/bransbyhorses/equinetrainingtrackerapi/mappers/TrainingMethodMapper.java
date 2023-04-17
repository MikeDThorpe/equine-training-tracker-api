package uk.co.bransbyhorses.equinetrainingtrackerapi.mappers;

import org.mapstruct.Mapper;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.TrainingMethod;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.dto.TrainingMethodDto;

@Mapper(componentModel = "spring")
public interface TrainingMethodMapper extends ModelMapper<TrainingMethod, TrainingMethodDto> {
}
