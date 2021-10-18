package ua.goit.Controller;

import ua.goit.View.Commands;
import ua.goit.View.InputString;
import ua.goit.View.View;
import ua.goit.model.Developer;
import ua.goit.repositoty.DeveloperRepositoryImpl;
import ua.goit.service.DeveloperServiceImpl;

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

        Long developerID = Long.parseLong(view.read());
        Optional<Developer> developer = developerRepository.findById(developerID);

        if (developer == null)
            throw new IllegalArgumentException(String.format("Developer with id %d not exist", developerID));

        developerRepository.deleteById(developerID);
        view.write("Developer deleted");
    }
}
