package ua.goit.repositoty;

import ua.goit.model.BaseEntity;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class BaseReposiroryImpl implements BaseRepository {
    @Override
    public BaseEntity getOne(Object o) {
        return null;
    }

    @Override
    public List saveAll(Iterable itrbl) {
        return null;
    }

    @Override
    public Collection findAll() {
        return null;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteById(Object o) {

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public boolean existsById(Object o) {
        return false;
    }

    @Override
    public Optional findById(Object o) {
        return Optional.empty();
    }

    @Override
    public BaseEntity save(BaseEntity baseEntity) {
        return null;
    }
}

class BaseRepositoryProxy implements BaseRepository {

    private final BaseRepository repo;

    public BaseRepositoryProxy(BaseRepository repo) {
        this.repo = repo;
    }

    @Override
        public BaseEntity getOne(Object id) {
           return repo.getOne(id);
        }

        @Override
        public List saveAll(Iterable itrbl) {
            return null;
        }

        @Override
        public Collection findAll() {
            return null;
        }

        @Override
        public void deleteAll() {

        }

        @Override
        public void deleteById(Object o) {

        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public boolean existsById(Object o) {
            return false;
        }

        @Override
        public Optional findById(Object o) {
            return Optional.empty();
        }

        @Override
        public BaseEntity save(BaseEntity baseEntity) {
            return null;
        }
    }
