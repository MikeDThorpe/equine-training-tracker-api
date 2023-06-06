package uk.co.bransbyhorses.equinetrainingtrackerapi.mappers;

import org.mapstruct.Mapper;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.SkillTrainingSession;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.dto.SkillTrainingSessionDto;
import uk.co.bransbyhorses.equinetrainingtrackerapi.mappers.utils.DateMapper;

@Mapper(componentModel = "spring", uses = {DateMapper.class})
public interface SkillTrainingSessionMapper extends ModelMapper<SkillTrainingSession, SkillTrainingSessionDto> {
}
