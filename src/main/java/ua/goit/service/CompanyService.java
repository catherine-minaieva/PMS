package ua.goit.service;

import ua.goit.View.InputString;
import ua.goit.model.Company;
import ua.goit.repositoty.CompanyRepositoryImpl;
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
        repository.create(company);    }

    @Override
    public void update(Long id, Company company) {
        repository.update(id, company);
    }

    @Override
    public void delete(Long ID) {
        repository.deleteById(ID);
    }

    public Company mapCompany(InputString input) {
        String[] parameters = input.getParameters();

        Long id  = Long.parseLong(parameters[1]);
        String name = parameters[2];
        String headOffice = parameters[3];

        Company company = new Company();
        company.setId(id);
        company.setName(name);
        company.setHeadOffice(headOffice);

        return company;
    }
}
