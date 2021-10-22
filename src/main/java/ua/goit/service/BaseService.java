package ua.goit.service;

import ua.goit.model.BaseEntity;

import java.util.List;

public interface BaseService<T extends BaseEntity> {
    T findByID (Long id);
    List<T> findAll();

    void create(T t);
    void update(long ID, T t);
    void delete(Long ID);

}
