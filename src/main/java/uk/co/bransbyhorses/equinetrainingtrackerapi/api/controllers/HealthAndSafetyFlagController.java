package uk.co.bransbyhorses.equinetrainingtrackerapi.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.HealthAndSafetyFlag;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.dto.HealthAndSafetyFlagDto;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.services.HealthAndSafetyFlagService;
import uk.co.bransbyhorses.equinetrainingtrackerapi.constants.ApiMappingConstants;
import uk.co.bransbyhorses.equinetrainingtrackerapi.mappers.HealthAndSafetyFlagMapper;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = ApiMappingConstants.HEALTH_AND_SAFETY_FLAG_ROUTE)
public class HealthAndSafetyFlagController {

    private final HealthAndSafetyFlagService service;
    private final HealthAndSafetyFlagMapper mapper;

    @GetMapping
    public ResponseEntity<List<HealthAndSafetyFlagDto>> getHealthAndSafetyFlags() {
        List<HealthAndSafetyFlagDto> healthAndSafetyFlags = service.getAllRecords()
                .stream()
                .map(mapper::mapToDto)
                .toList();
        return ResponseEntity
                .ok()
                .body(healthAndSafetyFlags);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<HealthAndSafetyFlagDto> getHealthAndSafetyFlag(@PathVariable(value = "id")UUID id) {
        HealthAndSafetyFlagDto healthAndSafetyFlag = mapper.mapToDto(service.getOneRecord(id));
        return ResponseEntity
                .ok()
                .body(healthAndSafetyFlag);
    }

    @PostMapping
    public ResponseEntity<HealthAndSafetyFlagDto> createHealthAndSafetyFlag(
            @RequestBody HealthAndSafetyFlagDto healthAndSafetyFlag) {
        HealthAndSafetyFlag savedHealthAndSafetyFlag = service.createRecord(mapper.mapToEntity(healthAndSafetyFlag));
        URI resourceURI = URI.create(ApiMappingConstants.HEALTH_AND_SAFETY_FLAG_ROUTE + savedHealthAndSafetyFlag.getId().toString());
        return ResponseEntity
                .created(resourceURI)
                .body(mapper.mapToDto(savedHealthAndSafetyFlag));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<HealthAndSafetyFlagDto> updateHealthAndSafetyFlag(
            @PathVariable(value = "id")UUID id,
            @RequestBody HealthAndSafetyFlagDto healthAndSafetyFlag) {
        HealthAndSafetyFlag updatedHealthAndSafetyFlag = service.updateRecord(mapper.mapToEntity(healthAndSafetyFlag), id);
        return ResponseEntity
                .ok()
                .body(mapper.mapToDto(updatedHealthAndSafetyFlag));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteHealthAndSafetyFlag(@PathVariable(value = "id") UUID id) {
        service.deleteRecord(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
