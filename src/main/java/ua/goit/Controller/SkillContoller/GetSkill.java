package ua.goit.Controller.SkillContoller;

import ua.goit.Controller.Command;
import ua.goit.View.Commands;
import ua.goit.View.InputString;
import ua.goit.View.View;
import ua.goit.model.Company;
import ua.goit.model.Skill;
import ua.goit.service.SkillService;

public class GetSkill implements Command {

    private View view;
    private SkillService service;

    public GetSkill(View view, SkillService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public String command() {
        return Commands.GET_SKILL;
    }

    @Override
    public void process(InputString input) {
        int idPosition = 1;
        String id = input.getParameters()[idPosition];
        Long skillId = Long.parseLong(id);
        Skill skill = service.findByID(skillId);

        if (skill.getID() == null)
            throw new IllegalArgumentException(String.format("Company with id %d not exist", skillId));
        view.write(skill.toString());
    }
}
