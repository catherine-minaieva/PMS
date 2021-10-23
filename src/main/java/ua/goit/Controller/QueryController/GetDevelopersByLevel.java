package ua.goit.Controller.QueryController;

import ua.goit.Controller.Command;
import ua.goit.View.Commands;
import ua.goit.View.InputString;
import ua.goit.View.View;
import ua.goit.service.QueryServiceImpl;

public class GetDevelopersByLevel implements Command {

    private View view;
    private QueryServiceImpl service;

    public GetDevelopersByLevel(View view, QueryServiceImpl service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public String command() {
        return Commands.GET_DEVELOPERS_LEVEL;
    }

    @Override
    public void process(InputString input) {

    }
}
