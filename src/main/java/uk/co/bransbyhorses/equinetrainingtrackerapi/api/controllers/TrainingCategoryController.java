package uk.co.bransbyhorses.equinetrainingtrackerapi.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.dto.TrainingCategoryDto;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.services.TrainingCategoryService;
import uk.co.bransbyhorses.equinetrainingtrackerapi.constants.ApiMappingConstants;
import uk.co.bransbyhorses.equinetrainingtrackerapi.mappers.TrainingCategoryMapper;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = ApiMappingConstants.TRAINING_CATEGORY_ROUTE)
public class TrainingCategoryController {

    @Autowired private final TrainingCategoryService service;
    @Autowired private final TrainingCategoryMapper mapper;

    @GetMapping
    public ResponseEntity<List<TrainingCategoryDto>> getAllTrainingCategories() {
        List<TrainingCategoryDto> trainingCategories = service.getAllRecords().stream()
                .map(mapper::mapToDto)
                .toList();
        return ResponseEntity
                .ok()
                .body(trainingCategories);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<TrainingCategoryDto> getTrainingCategory(@PathVariable(value = "id")UUID id) {
        TrainingCategoryDto trainingCategory = mapper.mapToDto(service.getOneRecord(id));
        return ResponseEntity
                .ok()
                .body(trainingCategory);
    }
}
