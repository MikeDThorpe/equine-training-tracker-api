package uk.co.bransbyhorses.equinetrainingtrackerapi.mappers;

import org.mapstruct.Mapper;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.Yard;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.dto.YardDto;

@Mapper(componentModel = "spring")
public interface YardMapper extends ModelMapper<Yard, YardDto> {
}
