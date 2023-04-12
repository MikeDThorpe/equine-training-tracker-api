package uk.co.bransbyhorses.equinetrainingtrackerapi.api.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.LearnerType;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.dto.LearnerTypeDto;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.services.LearnerTypeService;
import uk.co.bransbyhorses.equinetrainingtrackerapi.constants.ApiMappingConstants;
import uk.co.bransbyhorses.equinetrainingtrackerapi.mappers.LearnerTypeMapper;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping(value = ApiMappingConstants.LEARNER_TYPE_ROUTE)
public class LearnerTypeController {

    private LearnerTypeService service;
    private LearnerTypeMapper mapper;

    @GetMapping
    public ResponseEntity<List<LearnerTypeDto>> getLearnerTypes() {
        List<LearnerTypeDto> learnerTypes = service.getAllRecords()
                .stream()
                .map(mapper::mapToDto)
                .toList();
        return ResponseEntity
                .ok()
                .body(learnerTypes);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<LearnerTypeDto> getLearnerType(@PathVariable(name = "id")UUID id) {
        LearnerType learnerType = service.getOneRecord(id);
        return ResponseEntity
                .ok()
                .body(mapper.mapToDto(learnerType));
    }

    @PostMapping
    public ResponseEntity<LearnerTypeDto> createLearnerType(@RequestBody LearnerTypeDto newLearnerType) {
        LearnerType newLearnerTypeSaved = service.createRecord(mapper.mapToEntity(newLearnerType));
        URI resourcePath = URI.create(ApiMappingConstants.LEARNER_TYPE_ROUTE + "/" + newLearnerTypeSaved.getId().toString());
        return ResponseEntity
                .created(resourcePath)
                .body(mapper.mapToDto(newLearnerTypeSaved));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<LearnerTypeDto> updateLearnerType(
            @PathVariable(value = "id") UUID id,
            @RequestBody LearnerTypeDto updatedLearnerTypeValues) {
        LearnerType updatedLearnerType = service.updateRecord(mapper.mapToEntity(updatedLearnerTypeValues), id);
        return ResponseEntity
                .ok()
                .body(mapper.mapToDto(updatedLearnerType));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<LearnerTypeDto> deleteLearnerType(@PathVariable(name = "id")UUID id) {
        service.deleteRecord(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
