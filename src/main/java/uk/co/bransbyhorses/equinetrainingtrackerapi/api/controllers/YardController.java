package uk.co.bransbyhorses.equinetrainingtrackerapi.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.Yard;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.dto.YardDto;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.services.YardService;
import uk.co.bransbyhorses.equinetrainingtrackerapi.constants.ApiMappingConstants;
import uk.co.bransbyhorses.equinetrainingtrackerapi.mappers.YardMapper;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = ApiMappingConstants.YARD_ROUTE)
public class YardController {

    private final YardService service;
    private final YardMapper mapper;

    @GetMapping
    public ResponseEntity<List<YardDto>> getYards() {
        List<YardDto> yards = service.getAllRecords()
                .stream().map(mapper::mapToDto).toList();
        return ResponseEntity
                .ok()
                .body(yards);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<YardDto> getYard(@PathVariable(value = "id")UUID id) {
       YardDto yard = mapper.mapToDto(service.getOneRecord(id));
        return ResponseEntity
                .ok()
                .body(yard);
    }

    @PostMapping
    public ResponseEntity<YardDto> createYard(
            @RequestBody YardDto newYard) {
        Yard savedYard = service.createRecord(mapper.mapToEntity(newYard));
        return ResponseEntity
                .ok()
                .body(mapper.mapToDto(savedYard));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<YardDto> updateYard(
            @RequestBody YardDto updatedYard,
            @PathVariable UUID id) {
        Yard savedYard = service.updateRecord(mapper.mapToEntity(updatedYard), id);
        return ResponseEntity
                .ok()
                .body(mapper.mapToDto(savedYard));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deleteYard(@PathVariable(value = "id")UUID id) {
        service.deleteRecord(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
