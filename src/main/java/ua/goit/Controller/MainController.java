package ua.goit.Controller;

import ua.goit.Controller.DeveloperController.CreateDeveloper;
import ua.goit.Controller.DeveloperController.DeleteDeveloper;
import ua.goit.Controller.DeveloperController.GetAllDevelopers;
import ua.goit.Controller.DeveloperController.GetDeveloper;
import ua.goit.View.InputString;
import ua.goit.View.View;
import ua.goit.exeption.ExitException;
import ua.goit.repositoty.DeveloperRepositoryImpl;
import ua.goit.service.DeveloperServiceImpl;

import java.util.Arrays;
import java.util.List;

public class MainController {
    private View view;
    private List<Command> commands;

    public MainController(View view) {
        this.view = view;
        DeveloperServiceImpl developerService = new DeveloperServiceImpl(new DeveloperRepositoryImpl());
        DeveloperRepositoryImpl developerRepository = new DeveloperRepositoryImpl();
        this.commands = Arrays.asList(
                new CreateDeveloper(view, developerService),
                new DeleteDeveloper(view, developerRepository),
                new GetDeveloper(view, developerService),
                new GetAllDevelopers(view, developerService),
                new Exit(view)
        );
    }

    public void read() {
        view.write("Hello");
        view.write("Enter a command:");
        try {
            doCommand();
        } catch (ExitException e) {

        }
    }

    private void doCommand() {
        while (true) {
            InputString entry = new InputString(view.read());
            for (Command command : commands) {
                try {
                    if (command.canProcess(entry)) {
                        entry.validateParameters(command.command());
                        command.process(entry);
                        break;
                    }
                } catch (Exception e) {
                    if (e instanceof ExitException) {
                        throw e;
                    }
                    printError(e);
                    break;
                }
            }
        }
    }

    private void printError(Exception e) {
        String message = e.getMessage();
        view.write("Error because of " + message);
        view.write("Please try again");
    }
}
