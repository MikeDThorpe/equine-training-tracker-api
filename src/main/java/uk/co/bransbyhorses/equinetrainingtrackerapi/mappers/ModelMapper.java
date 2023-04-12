package uk.co.bransbyhorses.equinetrainingtrackerapi.mappers;

public interface ModelMapper<E, D> {

    E mapToEntity(D d);

    D mapToDto(E e);
}
