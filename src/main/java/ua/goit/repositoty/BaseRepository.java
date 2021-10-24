package ua.goit.repositoty;

import lombok.SneakyThrows;
import ua.goit.model.BaseEntity;
import ua.goit.model.Skill;

import java.util.Collection;

public interface BaseRepository <E extends BaseEntity<ID>, ID> {

   Collection<E> findAll();

    void deleteById(ID id);

    E findById(ID id);

    E create(E e);

    E update(ID id, E e);

}
