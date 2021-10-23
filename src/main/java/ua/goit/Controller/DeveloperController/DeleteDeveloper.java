package ua.goit.Controller.DeveloperController;

import ua.goit.Controller.Command;
import ua.goit.View.Commands;
import ua.goit.View.InputString;
import ua.goit.View.View;
import ua.goit.service.DeveloperService;

public class DeleteDeveloper implements Command {
    private final View view;
    private final DeveloperService service;

    public DeleteDeveloper(View view, DeveloperService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public String command() {
        return Commands.DELETE_DEVELOPER;
    }

    @Override
    public void process(InputString input) {

        int idPosition = 1;
        String id = input.getParameters()[idPosition];
        Long developerID = Long.parseLong(id);

        //if (!developer.isPresent())
           // throw new IllegalArgumentException(String.format("Developer with id %d not exist", developerID));

        service.delete(developerID);
        view.write("Developer deleted");
    }
}
