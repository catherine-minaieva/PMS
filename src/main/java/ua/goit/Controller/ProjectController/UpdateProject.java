package ua.goit.Controller.ProjectController;

import ua.goit.Controller.Command;
import ua.goit.View.Commands;
import ua.goit.View.InputString;
import ua.goit.View.View;
import ua.goit.model.Project;
import ua.goit.service.ProjectService;

public class UpdateProject implements Command {

    private View view;
    private ProjectService service;

    public UpdateProject(View view, ProjectService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public String command() {
        return Commands.UPDATE_PROJECT;
    }

    @Override
    public void process(InputString input) {
        Project project = service.mapProject(input);
        service.create(project);
        view.write(String.format("Project with name - %s updated", project.getName()));
    }
}
