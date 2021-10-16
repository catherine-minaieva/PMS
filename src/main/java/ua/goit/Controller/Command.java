package ua.goit.Controller;

import ua.goit.View.InputString;

public interface Command {
    int COMMAND_NAME_INDEX = 0;

    String command();

    void process(InputString input);

    default boolean canProcess(InputString userInput) {
        String[] splitFormat = command().split("\\|");
        String[] inputParameters = userInput.getParameters();
        return inputParameters[COMMAND_NAME_INDEX].equalsIgnoreCase(splitFormat[COMMAND_NAME_INDEX]);
    }
}
