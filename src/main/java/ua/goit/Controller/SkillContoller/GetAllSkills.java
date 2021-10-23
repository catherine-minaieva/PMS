package ua.goit.Controller.SkillContoller;

import ua.goit.Controller.Command;
import ua.goit.View.Commands;
import ua.goit.View.InputString;
import ua.goit.View.View;
import ua.goit.service.SkillService;

public class GetAllSkills implements Command {

    private View view;
    private SkillService service;

    public GetAllSkills(View view, SkillService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public String command() {
        return Commands.GET_ALL_SKILLS;
    }

    @Override
    public void process(InputString input) {

    }
}
