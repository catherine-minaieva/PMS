package ua.goit.Controller.SkillContoller;

import ua.goit.Controller.Command;
import ua.goit.View.Commands;
import ua.goit.View.InputString;
import ua.goit.View.View;
import ua.goit.model.Skill;
import ua.goit.service.SkillService;

public class UpdateSkill implements Command {

    private View view;
    private SkillService service;

    public UpdateSkill(View view, SkillService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public String command() {
        return Commands.UPDATE_SKILL;
    }

    @Override
    public void process(InputString input) {
        Skill skill = service.mapSkill(input);
        service.create(skill);
        view.write(String.format("Skill created - %s", skill.getLanguage(), skill.getLevel()));
    }
}
