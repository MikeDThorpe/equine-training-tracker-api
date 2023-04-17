package uk.co.bransbyhorses.equinetrainingtrackerapi.api.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Service;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.models.HealthAndSafetyFlag;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.repositories.HealthAndSafetyFlagRepository;
import uk.co.bransbyhorses.equinetrainingtrackerapi.api.services.HealthAndSafetyFlagService;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class HealthAndSafetyFlagServiceImpl implements HealthAndSafetyFlagService {

    private final HealthAndSafetyFlagRepository repository;

    @Override
    public HealthAndSafetyFlag getOneRecord(UUID id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<HealthAndSafetyFlag> getAllRecords() {
        return repository.findAll();
    }

    @Override
    public HealthAndSafetyFlag createRecord(HealthAndSafetyFlag newHealthAndSafetyFlag) {
        return repository.save(newHealthAndSafetyFlag);
    }

    @Override
    public HealthAndSafetyFlag updateRecord(HealthAndSafetyFlag updatedHealthAndSafetyFlag, UUID id) {
        HealthAndSafetyFlag healthAndSafetyFlag = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        healthAndSafetyFlag.setContent(updatedHealthAndSafetyFlag.getContent());
        return repository.save(healthAndSafetyFlag);
    }

    @Override
    public void deleteRecord(UUID id) {
        HealthAndSafetyFlag healthAndSafetyFlag = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        repository.delete(healthAndSafetyFlag);
    }
}
