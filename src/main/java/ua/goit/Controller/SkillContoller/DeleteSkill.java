package ua.goit.Controller.SkillContoller;

import ua.goit.Controller.Command;
import ua.goit.View.Commands;
import ua.goit.View.InputString;
import ua.goit.View.View;
import ua.goit.service.SkillService;

public class DeleteSkill implements Command {

    private View view;
    private SkillService service;

    public DeleteSkill(View view, SkillService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public String command() {
        return Commands.DELETE_SKILL;
    }

    @Override
    public void process(InputString input) {
        int idPosition = 1;
        String id = input.getParameters()[idPosition];
        Long skillId = Long.parseLong(id);
        service.delete(skillId);
        view.write("Skill deleted");
    }
}
