package ua.goit.repositoty;

import ua.goit.model.BaseEntity;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface BaseRepository <E extends BaseEntity<ID>, ID> {

   public Collection<E> findAll();

    public void deleteById(ID id);

    public Optional<E> findById(ID id);

    public E create(E e);

    public E update(ID id, E e);

}
