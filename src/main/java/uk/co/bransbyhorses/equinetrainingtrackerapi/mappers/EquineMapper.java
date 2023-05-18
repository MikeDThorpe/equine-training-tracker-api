package uk.co.bransbyhorses.equinetrainingtrackerapi.mappers;

import org.mapstruct.Mapper;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.Equine;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.dto.EquineDto;
import uk.co.bransbyhorses.equinetrainingtrackerapi.mappers.utils.DateMapper;

@Mapper(componentModel = "spring", uses = {DateMapper.class})
public interface EquineMapper extends ModelMapper<Equine, EquineDto> {
}
