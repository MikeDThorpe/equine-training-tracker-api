package uk.co.bransbyhorses.equinetrainingtrackerapi.api.services;

import java.util.List;
import java.util.UUID;

public interface ApiCrudService<T> {

    T getOneRecord(UUID id);

    List<T> getAllRecords();

    T createRecord(T newRecord);

    T updateRecord(T record, UUID id);

    void deleteRecord(UUID id);
}
