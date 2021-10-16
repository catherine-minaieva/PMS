package ua.goit.Controller;

import ua.goit.View.Commands;
import ua.goit.View.InputString;
import ua.goit.View.View;

public class Exit implements Command{
    private View view;

    public Exit(View view) {
        this.view = view;
    }

    @Override
    public String command() {
        return Commands.EXIT;
    }

    @Override
    public void process(InputString input) {
        view.write("Good bye");
        throw new RuntimeException("Exit");
    }
}
