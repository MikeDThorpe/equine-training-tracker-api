package uk.co.bransbyhorses.equinetrainingtrackerapi.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.Disruption;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.dto.DisruptionDto;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.services.DisruptionService;
import uk.co.bransbyhorses.equinetrainingtrackerapi.constants.ApiMappingConstants;
import uk.co.bransbyhorses.equinetrainingtrackerapi.mappers.DisruptionMapper;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = ApiMappingConstants.DISRUPTION_ROUTE)
public class DisruptionController {

    private final DisruptionService service;
    private final DisruptionMapper mapper;

    @GetMapping
    public ResponseEntity<List<DisruptionDto>> getDisruptions() {
        List<DisruptionDto> disruptions = service.getAllRecords().stream()
                .map(mapper::mapToDto)
                .toList();
        return ResponseEntity
                .ok()
                .body(disruptions);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<DisruptionDto> getDisruption(@PathVariable(value = "id")UUID id) {
        Disruption disruption = service.getOneRecord(id);
        return ResponseEntity
                .ok()
                .body(mapper.mapToDto(disruption));
    }

    @PostMapping
    public ResponseEntity<DisruptionDto> createDisruption(
            @RequestBody DisruptionDto disruption) {
        Disruption savedDisruption = service.createRecord(mapper.mapToEntity(disruption));
        URI resourceURI = URI.create(ApiMappingConstants.DISRUPTION_ROUTE + savedDisruption.getId().toString());
        return ResponseEntity
                .created(resourceURI)
                .body(mapper.mapToDto(savedDisruption));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<DisruptionDto> updateDisruption(
            @PathVariable(value = "id") UUID id,
            @RequestBody DisruptionDto updatedDisruptionValues) {
        Disruption savedDisruption = service.updateRecord(mapper.mapToEntity(updatedDisruptionValues), id);
        return ResponseEntity
                .ok()
                .body(mapper.mapToDto(savedDisruption));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> deleteDisruption(@PathVariable(value = "id")UUID id) {
        service.deleteRecord(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
