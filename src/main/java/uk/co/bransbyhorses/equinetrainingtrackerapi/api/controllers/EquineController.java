package uk.co.bransbyhorses.equinetrainingtrackerapi.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.Equine;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.dto.EquineDto;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.services.EquineService;
import uk.co.bransbyhorses.equinetrainingtrackerapi.constants.ApiMappingConstants;
import uk.co.bransbyhorses.equinetrainingtrackerapi.mappers.EquineMapper;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = ApiMappingConstants.EQUINE_ROUTE)
public class EquineController {

    private final EquineService service;
    private final EquineMapper mapper;

    @GetMapping(value = "{id}")
    public ResponseEntity<EquineDto> getEquine(@PathVariable(value = "id")UUID id) {
        Equine equine = service.getOneRecord(id);
        return ResponseEntity
                .ok()
                .body(mapper.mapToDto(equine));
    }

    @GetMapping
    public ResponseEntity<List<EquineDto>> getAllEquines() {
        List<EquineDto> equines = service.getAllRecords().stream().map(mapper::mapToDto).toList();
        return ResponseEntity
                .ok()
                .body(equines);
    }

    @PostMapping
    public ResponseEntity<EquineDto> createEquine(@RequestBody EquineDto newEquine) {
        Equine equine = service.createRecord(mapper.mapToEntity(newEquine));
        URI resourceURI = URI.create(ApiMappingConstants.EQUINE_ROUTE + "/" + equine.getId().toString());
        return ResponseEntity
                .created(resourceURI)
                .body(mapper.mapToDto(equine));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<EquineDto> updateEquine(
            @PathVariable(value = "id")UUID id,
            @RequestBody EquineDto updatedEquine) {
        Equine equine = service.updateRecord(mapper.mapToEntity(updatedEquine), id);
        return ResponseEntity
                .ok()
                .body(mapper.mapToDto(equine));

    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> deleteEquine(@PathVariable(value = "id")UUID id) {
        service.deleteRecord(id);
        return ResponseEntity
                .noContent()
                .build();
    }

}
