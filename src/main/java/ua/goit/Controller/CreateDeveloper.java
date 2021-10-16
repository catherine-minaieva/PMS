package ua.goit.Controller;

import ua.goit.View.Commands;
import ua.goit.View.InputString;
import ua.goit.View.View;
import ua.goit.model.Developer;
import ua.goit.service.DeveloperServiceImpl;

public class CreateDeveloper implements Command {
    private View view;
    private DeveloperServiceImpl service;

    public CreateDeveloper(View view) {
        this.view = view;
        this.service = service;
    }

    @Override
    public String command() {
        return Commands.CREATE_DEVELOPER;
    }

    @Override
    public void process(InputString input) {
        Developer developer = service.
                mapDeveloper(input);
        service.create(developer);
        view.write(String.format("Developer created with name - %s", developer.getName()));
    }
}
