package ua.goit.Controller.DeveloperController;

import ua.goit.Controller.Command;
import ua.goit.View.Commands;
import ua.goit.View.InputString;
import ua.goit.View.View;
import ua.goit.model.Developer;
import ua.goit.service.DeveloperServiceImpl;

public class UpdateDeveloper implements Command {

    private View view;
    private DeveloperServiceImpl service;

    public UpdateDeveloper(View view, DeveloperServiceImpl service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public String command() {
        return Commands.UPDATE_DEVELOPER;
    }

    @Override
    public void process(InputString input) {
        int idPosition = 1;
        String id = input.getParameters()[idPosition];
        Long developerID = Long.parseLong(id);
        Developer developer = service.mapDeveloper(input);
        service.update(developerID,developer);
        view.write(String.format("Developer with name - %s updated", developer.getName()));
    }
}
