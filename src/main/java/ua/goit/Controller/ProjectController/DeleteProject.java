package ua.goit.Controller.ProjectController;

import ua.goit.Controller.Command;
import ua.goit.View.InputString;
import ua.goit.View.View;
import ua.goit.service.ProjectService;

public class DeleteProject implements Command {

    private View view;
    private ProjectService service;

    public DeleteProject(View view, ProjectService service) {
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
