package ua.goit.Controller.ProjectController;

import ua.goit.Controller.Command;
import ua.goit.View.Commands;
import ua.goit.View.InputString;
import ua.goit.View.View;
import ua.goit.service.ProjectService;

public class GetAllProjects implements Command {

    private View view;
    private ProjectService service;

    public GetAllProjects(View view, ProjectService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public String command() {
        return Commands.GET_ALL_PROJECTS;
    }

    @Override
    public void process(InputString input) {

    }
}
