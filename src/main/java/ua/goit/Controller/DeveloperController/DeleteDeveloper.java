package ua.goit.Controller.DeveloperController;

import ua.goit.Controller.Command;
import ua.goit.View.Commands;
import ua.goit.View.InputString;
import ua.goit.View.View;
import ua.goit.model.Developer;
import ua.goit.repositoty.DeveloperRepositoryImpl;


import java.util.Optional;

public class DeleteDeveloper implements Command {
    private View view;
    private DeveloperRepositoryImpl developerRepository;

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

        Long developerID = Long.parseLong(String.valueOf((input)));
        Optional<Developer> developer = developerRepository.findById(developerID);

        if (developer.isEmpty())
            throw new IllegalArgumentException(String.format("Developer with id %d not exist", developerID));

        developerRepository.deleteById(developerID);
        view.write("Developer deleted");
    }
}
