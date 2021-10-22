package ua.goit.Controller.DeveloperController;

import ua.goit.Controller.Command;
import ua.goit.View.Commands;
import ua.goit.View.InputString;
import ua.goit.View.View;
import ua.goit.service.DeveloperServiceImpl;

public class GetDeveloper implements Command {

    private View view;
    private DeveloperServiceImpl service;

    public GetDeveloper(View view, DeveloperServiceImpl service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public String command() {
        return Commands.GET_DEVELOPER;
    }

    @Override
    public void process(InputString input) {

    }
}
