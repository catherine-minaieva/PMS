package ua.goit.Controller.DeveloperController;

import ua.goit.Controller.Command;
import ua.goit.View.Commands;
import ua.goit.View.InputString;
import ua.goit.View.View;
import ua.goit.model.Developer;
import ua.goit.repositoty.DeveloperRepositoryImpl;


import java.util.Optional;

public class DeleteDeveloper implements Command {
    private final View view;
    private final DeveloperRepositoryImpl developerRepository;

    public DeleteDeveloper(View view, DeveloperRepositoryImpl developerRepository ) {
        this.view = view;
        this.developerRepository = developerRepository;
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
        Optional<Developer> developer = developerRepository.findById(developerID);

        if (developer.isEmpty())
            throw new IllegalArgumentException(String.format("Developer with id %d not exist", developerID));

        developerRepository.deleteById(developerID);
        view.write("Developer deleted");
    }
}
