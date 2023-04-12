package uk.co.bransbyhorses.equinetrainingtrackerapi.mappers;

import org.mapstruct.Mapper;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.TrainingCategory;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.dto.TrainingCategoryDto;

@Mapper(componentModel = "spring")
public interface TrainingCategoryMapper extends ModelMapper<TrainingCategory, TrainingCategoryDto> {
}
