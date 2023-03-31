package uk.co.bransbyhorses.equinetrainingtrackerapi.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.TrainingSkill;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.dto.TrainingSkillDto;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.services.TrainingSkillService;
import uk.co.bransbyhorses.equinetrainingtrackerapi.constants.ApiMappingConstants;
import uk.co.bransbyhorses.equinetrainingtrackerapi.mappers.TrainingSkillMapper;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = ApiMappingConstants.TRAINING_SKILL_ROUTE)
public class TrainingSkillController {

    @Autowired private final TrainingSkillService service;
    @Autowired private final TrainingSkillMapper mapper;

    @GetMapping(value = "{id}")
    public ResponseEntity<TrainingSkillDto> getTrainingSkill(@PathVariable(value = "id")UUID id) {
        TrainingSkill trainingSkill = service.getOneRecord(id);
        return ResponseEntity
                .ok()
                .body(mapper.mapToDto(trainingSkill));
    }

    @GetMapping
    public ResponseEntity<List<TrainingSkillDto>> getTrainingSkills() {
        List<TrainingSkillDto> trainingSkills = service.getAllRecords().stream().map(mapper::mapToDto).toList();
        return ResponseEntity
                .ok()
                .body(trainingSkills);
    }

    @PostMapping
    public ResponseEntity<TrainingSkillDto> createTrainingSkill(@RequestBody TrainingSkillDto trainingSkill) {
        TrainingSkill savedTrainingSkill = service.createRecord(mapper.mapToEntity(trainingSkill));
        URI resourcePath =
                URI.create(ApiMappingConstants.TRAINING_SKILL_ROUTE + "/" + savedTrainingSkill.getId().toString());
        return ResponseEntity
                .created(resourcePath)
                .body(mapper.mapToDto(savedTrainingSkill));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<TrainingSkillDto> updateTrainingSkill(
            @PathVariable(value = "id")UUID id,
            @RequestBody TrainingSkillDto updatedTrainingSkillValues)
    {
        TrainingSkill updatedTrainingSkill = service.updateRecord(mapper.mapToEntity(updatedTrainingSkillValues), id);
        return ResponseEntity
                .ok()
                .body(mapper.mapToDto(updatedTrainingSkill));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deleteTrainingSkill(@PathVariable(value = "id")UUID id) {
        service.deleteRecord(id);
        return ResponseEntity.noContent().build();
    }
}
