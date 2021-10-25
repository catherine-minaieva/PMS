package ua.goit.service;

import ua.goit.View.InputString;
import ua.goit.model.Skill;
import ua.goit.repositoty.SkillRepositoryImpl;
import java.util.Collection;
import java.util.List;

public class SkillService implements BaseService<Skill> {

    private final SkillRepositoryImpl repository;

    public SkillService(SkillRepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public Skill findByID(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Skill> findAll() {
        Collection<Skill> all = repository.findAll();
        return (List<Skill>) all;
    }

    @Override
    public void create(Skill skill) {
        repository.create(skill);
    }

    @Override
    public void update(Long id, Skill skill) {
        repository.update(id, skill);
    }

    @Override
    public void delete(Long ID) {
        repository.deleteById(ID);
    }

    public Skill mapSkill(InputString input) {
        String[] parameters = input.getParameters();

        Long id  = Long.parseLong(parameters[1]);
        String language = parameters[2];
        String level = parameters[3];

        Skill skill = new Skill();
        skill.setId(id);
        skill.setLanguage(language);
        skill.setLevel(level);

        return skill;
    }
}
