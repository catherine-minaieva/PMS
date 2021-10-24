package ua.goit.service;

import ua.goit.View.InputString;
import ua.goit.model.Developer;
import ua.goit.repositoty.DeveloperRepositoryImpl;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperRepositoryImpl repository;

    public DeveloperServiceImpl(DeveloperRepositoryImpl repository){
        this.repository = repository;
    }

    @Override
    public Developer findByID(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Developer> findAll() {
        Collection<Developer> all = repository.findAll();
        return (List<Developer>) all;
    }

    @Override
    public void create(Developer developer) {
        repository.create(developer);
    }

    @Override
    public void update(Long id, Developer developer) {
        repository.update(id, developer);
    }

    @Override
    public void delete(Long ID) {
        repository.deleteById(ID);
    }

    @Override
    public Developer findByName(String name) {
        return null;
    }

    public Developer mapDeveloper(InputString input) {
        String[] parameters = input.getParameters();

        Long id  = Long.parseLong(parameters[1]);
        String name = parameters[2];
        int age = Integer.parseInt(parameters[3]);
        String gender = (parameters[4]);
        Double salary = Double.parseDouble(parameters[5]);

        Developer developer = new Developer();
        developer.setId(id);
        developer.setName(name);
        developer.setAge(age);
        developer.setGender(gender);
        developer.setSalary(salary);

        return developer;
    }
}
