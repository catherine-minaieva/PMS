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
        int idPosition = 1;
        String id = input.getParameters()[idPosition];
        Long projectId = Long.parseLong(id);
        Project project = service.findByID(projectId);
        if (project.getID() == null)
            throw new IllegalArgumentException(String.format("Company with id %d not exist", projectId));

        Project projectForUpdate = service.mapProject(input);
        service.update(projectId, projectForUpdate);
        view.write(String.format("Project with name - %s updated", project.getName()));
    }
}
