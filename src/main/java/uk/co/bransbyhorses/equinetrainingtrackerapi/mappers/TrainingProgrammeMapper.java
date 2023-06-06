package uk.co.bransbyhorses.equinetrainingtrackerapi.mappers;

import org.mapstruct.Mapper;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.TrainingProgramme;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.dto.TrainingProgrammeDto;
import uk.co.bransbyhorses.equinetrainingtrackerapi.mappers.utils.DateMapper;

@Mapper(componentModel = "spring", uses = {DateMapper.class})
public interface TrainingProgrammeMapper extends ModelMapper<TrainingProgramme, TrainingProgrammeDto> {}
