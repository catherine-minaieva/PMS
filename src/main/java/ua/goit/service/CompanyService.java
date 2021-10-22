package ua.goit.service;

import ua.goit.model.Company;
import ua.goit.repositoty.CompanyRepositoryImpl;
import ua.goit.repositoty.DeveloperRepositoryImpl;

import java.util.Collection;
import java.util.List;

public class CompanyService implements BaseService <Company> {

    private final CompanyRepositoryImpl repository;

    public CompanyService(CompanyRepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public Company findByID(Long id) {
        return null;
    }

    @Override
    public List<Company> findAll() {
        Collection<Company> all = repository.findAll();
        return (List<Company>) all;
    }

    @Override
    public void create(Company company) {
    }

    @Override
    public void update(Company company) {
    }

    @Override
    public void delete(Long ID) {

    }
}
