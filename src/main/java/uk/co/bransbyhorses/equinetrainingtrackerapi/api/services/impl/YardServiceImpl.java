package uk.co.bransbyhorses.equinetrainingtrackerapi.api.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.Yard;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.repositories.YardRepository;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.services.YardService;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class YardServiceImpl implements YardService {

    @Autowired private final YardRepository repository;

    @Override
    public Yard getOneRecord(UUID id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Yard> getAllRecords() {
        return repository.findAll();
    }

    @Override
    public Yard createRecord(Yard newYard) {
       return repository.save(newYard);
    }

    @Override
    public Yard updateRecord(Yard updatedYard, UUID id) {
        Yard yardToUpdate = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        yardToUpdate.setName(updatedYard.getName());
        return repository.save(yardToUpdate);
    }

    @Override
    public void deleteRecord(UUID id) {
        Yard yardToDelete = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        repository.delete(yardToDelete);
    }
}
