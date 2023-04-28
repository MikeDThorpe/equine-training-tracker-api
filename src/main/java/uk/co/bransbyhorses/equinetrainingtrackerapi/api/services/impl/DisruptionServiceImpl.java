package uk.co.bransbyhorses.equinetrainingtrackerapi.api.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.Disruption;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.repositories.DisruptionRepository;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.services.DisruptionService;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class DisruptionServiceImpl implements DisruptionService {

    private final DisruptionRepository repository;

    @Override
    public Disruption getOneRecord(UUID id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Disruption> getAllRecords() {
        return repository.findAll();
    }

    @Override
    public Disruption createRecord(Disruption newRecord) {
        return repository.save(newRecord);
    }

    @Override
    public Disruption updateRecord(Disruption updatedRecord, UUID id) {
        Disruption disruptionToUpdate = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        disruptionToUpdate.setDisruptionCode(updatedRecord.getDisruptionCode());
        disruptionToUpdate.setComment(updatedRecord.getComment());
        disruptionToUpdate.setStartDate(updatedRecord.getStartDate());
        disruptionToUpdate.setEndDate(updatedRecord.getEndDate());
        disruptionToUpdate.setIsActive(updatedRecord.getIsActive());
        disruptionToUpdate.setCreatedBy(updatedRecord.getCreatedBy());
        return repository.save(disruptionToUpdate);
    }

    @Override
    public void deleteRecord(UUID id) {
        Disruption disruptionToDelete = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        repository.delete(disruptionToDelete);
    }
}
