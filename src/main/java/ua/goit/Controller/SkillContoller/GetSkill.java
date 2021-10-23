package ua.goit.Controller.SkillContoller;

import ua.goit.Controller.Command;
import ua.goit.View.InputString;
import ua.goit.View.View;
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
        return null;
    }

    @Override
    public void process(InputString input) {

    }
}
