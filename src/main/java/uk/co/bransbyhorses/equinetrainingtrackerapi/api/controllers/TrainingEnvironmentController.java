package uk.co.bransbyhorses.equinetrainingtrackerapi.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.TrainingEnvironment;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.dto.TrainingEnvironmentDto;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.services.TrainingEnvironmentService;
import uk.co.bransbyhorses.equinetrainingtrackerapi.constants.ApiMappingConstants;
import uk.co.bransbyhorses.equinetrainingtrackerapi.mappers.TrainingEnvironmentMapper;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = ApiMappingConstants.TRAINING_ENVIRONMENT_ROUTE)
public class TrainingEnvironmentController {

    @Autowired private final TrainingEnvironmentService service;
    @Autowired private final TrainingEnvironmentMapper mapper;

    @GetMapping
    public ResponseEntity<List<TrainingEnvironmentDto>> getTrainingEnvironments() {
        List<TrainingEnvironmentDto> trainingEnvironments = service.getAllRecords()
                .stream()
                .map(mapper::mapToDto)
                .toList();
        return ResponseEntity
                .ok()
                .body(trainingEnvironments);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TrainingEnvironmentDto> getTrainingEnvironment(@PathVariable(name = "id") UUID id) {
        TrainingEnvironment trainingEnvironment = service.getOneRecord(id);
        return ResponseEntity
                .ok()
                .body(mapper.mapToDto(trainingEnvironment));
    }

    @PostMapping
    public ResponseEntity<TrainingEnvironmentDto> createTrainingEnvironment(@RequestBody TrainingEnvironmentDto trainingEnvironment) {
        TrainingEnvironment newTrainingEnvironment = service.createRecord(mapper.mapToEntity(trainingEnvironment));
        URI resourcePath = URI.create(ApiMappingConstants.TRAINING_ENVIRONMENT_ROUTE + "/" + newTrainingEnvironment.getId().toString());
        return ResponseEntity
                .created(resourcePath)
                .body(mapper.mapToDto(newTrainingEnvironment));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TrainingEnvironmentDto> updateTrainingEnvironment(
            @PathVariable(name = "id") UUID id,
            @RequestBody TrainingEnvironmentDto trainingEnvironment)
    {
        TrainingEnvironment updatedTrainingEnvironment = service.updateRecord(mapper.mapToEntity(trainingEnvironment), id);
        return ResponseEntity
                .ok()
                .body(mapper.mapToDto(updatedTrainingEnvironment));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteTrainingEnvironment(@PathVariable(name = "id") UUID id) {
        service.deleteRecord(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
