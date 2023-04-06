package uk.co.bransbyhorses.equinetrainingtrackerapi.mappers;

import org.mapstruct.Mapper;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.TrainingSkill;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.dto.TrainingSkillDto;

@Mapper(componentModel = "spring")
public interface TrainingSkillMapper {

    TrainingSkillDto mapToDto(TrainingSkill trainingEnvironment);

    TrainingSkill mapToEntity(TrainingSkillDto trainingEnvironment);
}
