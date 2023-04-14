package uk.co.bransbyhorses.equinetrainingtrackerapi.mappers;

import org.mapstruct.Mapper;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.HealthAndSafetyFlag;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.dto.HealthAndSafetyFlagDto;
import uk.co.bransbyhorses.equinetrainingtrackerapi.mappers.utils.DateMapper;

@Mapper(componentModel = "spring", uses = {DateMapper.class})
public interface HealthAndSafetyFlagMapper extends ModelMapper<HealthAndSafetyFlag, HealthAndSafetyFlagDto> {
}
