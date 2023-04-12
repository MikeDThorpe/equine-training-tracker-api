package uk.co.bransbyhorses.equinetrainingtrackerapi.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.TrainingMethod;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.dto.TrainingMethodDto;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.services.TrainingMethodService;
import uk.co.bransbyhorses.equinetrainingtrackerapi.constants.ApiMappingConstants;
import uk.co.bransbyhorses.equinetrainingtrackerapi.mappers.TrainingMethodMapper;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = ApiMappingConstants.TRAINING_METHOD_ROUTE)
public class TrainingMethodController {

    private final TrainingMethodService service;
    private final TrainingMethodMapper mapper;

    @GetMapping
    public ResponseEntity<List<TrainingMethodDto>> getTrainingMethods() {
        List<TrainingMethodDto> trainingMethods = service.getAllRecords()
                .stream().map(mapper::mapToDto).toList();
        return ResponseEntity
                .ok()
                .body(trainingMethods);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<TrainingMethodDto> getTrainingMethod(@PathVariable(value = "id") UUID id) {
        TrainingMethodDto trainingMethod = mapper.mapToDto(service.getOneRecord(id));
        return ResponseEntity
                .ok()
                .body(trainingMethod);
    }

    @PostMapping
    public ResponseEntity<TrainingMethodDto> createTrainingMethod(
            @RequestBody TrainingMethodDto newTrainingMethod) {
        TrainingMethod savedTrainingMethod = service.createRecord(mapper.mapToEntity(newTrainingMethod));
        return ResponseEntity
                .ok()
                .body(mapper.mapToDto(savedTrainingMethod));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<TrainingMethodDto> updateTrainingMethod(
            @RequestBody TrainingMethodDto updatedTrainingMethod,
            @PathVariable UUID id) {
        TrainingMethod savedTrainingMethod = service.updateRecord(mapper.mapToEntity(updatedTrainingMethod), id);
        return ResponseEntity
                .ok()
                .body(mapper.mapToDto(savedTrainingMethod));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deleteTrainingMethod(@PathVariable(value = "id")UUID id) {
        service.deleteRecord(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
