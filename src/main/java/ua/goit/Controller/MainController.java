package ua.goit.Controller;

import ua.goit.View.InputString;
import ua.goit.View.View;
import java.util.Arrays;
import java.util.List;

public class MainController {
    private View view;
    private List<Command> commands;

    public MainController(View view) {
        this.view = view;
        this.commands = Arrays.asList(
                new CreateDeveloper(view),
                new Exit(view)
        );
    }

    public void read() {
        view.write("Welcome to Project Management System!");
        view.write("Enter a command:");
        try {
            doCommand();
        } catch (RuntimeException e) {
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
                    throw e;
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
