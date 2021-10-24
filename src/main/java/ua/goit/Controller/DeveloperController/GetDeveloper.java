package ua.goit.Controller.DeveloperController;

import ua.goit.Controller.Command;
import ua.goit.View.Commands;
import ua.goit.View.InputString;
import ua.goit.View.View;
import ua.goit.model.Developer;
import ua.goit.service.DeveloperServiceImpl;

import java.util.Optional;

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
        int idPosition = 1;
        String id = input.getParameters()[idPosition];
        Long developerID = Long.parseLong(id);
        Developer developer = service.findByID(developerID);

        if (developer.getID() == null)
            throw new IllegalArgumentException(String.format("Developer with id %d not exist", developerID));

        view.write(developer.toString());
    }
}
