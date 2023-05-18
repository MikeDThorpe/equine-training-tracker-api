package uk.co.bransbyhorses.equinetrainingtrackerapi.api.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.Equine;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.repositories.EquineRepository;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.services.EquineService;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class EquineServiceImpl implements EquineService {

    private final EquineRepository repository;

    @Override
    public Equine getOneRecord(UUID id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Equine> getAllRecords() {
        return repository.findAll();
    }

    @Override
    public Equine createRecord(Equine newRecord) {
        return repository.save(newRecord);
    }

    @Override
    public Equine updateRecord(Equine updatedEquineValues, UUID id) {
        Equine equineToUpdate = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        equineToUpdate.setName(updatedEquineValues.getName());
        equineToUpdate.setEquineStatus(updatedEquineValues.getEquineStatus());
        equineToUpdate.setLearnerType(updatedEquineValues.getLearnerType());
        equineToUpdate.setYard(updatedEquineValues.getYard());
        return repository.save(equineToUpdate);
    }

    @Override
    public void deleteRecord(UUID id) {
        Equine equineToDelete = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        repository.delete(equineToDelete);
    }
}
