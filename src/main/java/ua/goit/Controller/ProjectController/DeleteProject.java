package ua.goit.Controller.ProjectController;

import ua.goit.Controller.Command;
import ua.goit.View.Commands;
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
        return Commands.DELETE_PROJECT;
    }

    @Override
    public void process(InputString input) {
        int idPosition = 1;
        String id = input.getParameters()[idPosition];
        Long projectId = Long.parseLong(id);
        service.delete(projectId);
        view.write("Project deleted");
    }
}
