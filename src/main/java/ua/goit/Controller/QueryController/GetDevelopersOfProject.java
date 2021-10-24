package ua.goit.Controller.QueryController;

import ua.goit.Controller.Command;
import ua.goit.View.Commands;
import ua.goit.View.InputString;
import ua.goit.View.View;
import ua.goit.model.Project;
import ua.goit.service.QueryServiceImpl;

public class GetDevelopersOfProject implements Command {

    private View view;
    private QueryServiceImpl service;

    public GetDevelopersOfProject(View view, QueryServiceImpl service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public String command() {
        return Commands.GET_DEVELOPERS_PROJECT;
    }

    @Override
    public void process(InputString input) {
        int idPosition = 1;
        String id = input.getParameters()[idPosition];
        Long projectId = Long.parseLong(id);
        service.developersOfProject(projectId).forEach(System.out::println);
    }
}
