package ua.goit.Controller.QueryController;

import ua.goit.Controller.Command;
import ua.goit.View.Commands;
import ua.goit.View.InputString;
import ua.goit.View.View;
import ua.goit.model.Project;
import ua.goit.service.ProjectService;
import ua.goit.service.QueryServiceImpl;

public class GetSumOfSalariesForProject implements Command {

    private View view;
    private QueryServiceImpl service;
    private ProjectService projectService;

    public GetSumOfSalariesForProject(View view, QueryServiceImpl service, ProjectService projectService) {
        this.view = view;
        this.service = service;
        this.projectService = projectService;
    }

    @Override
    public String command() {
        return Commands.GET_SUM_OF_PROJECT;
    }

    @Override
    public void process(InputString input) {
        int idPosition = 1;
        String id = input.getParameters()[idPosition];
        Long projectId = Long.parseLong(id);

        Project project = projectService.findByID(projectId);

        if (project.getID() == null)
            throw new IllegalArgumentException(String.format("Project with id %d not exist", projectId));
        service.sumOfSalariesForProject(project.getID());
    }
}
