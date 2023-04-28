package uk.co.bransbyhorses.equinetrainingtrackerapi.mappers;

import org.mapstruct.Mapper;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.Disruption;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.dto.DisruptionDto;
import uk.co.bransbyhorses.equinetrainingtrackerapi.mappers.utils.DateMapper;

@Mapper(componentModel = "spring", uses = {DateMapper.class})
public interface DisruptionMapper extends ModelMapper<Disruption, DisruptionDto> {

}
