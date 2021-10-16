package ua.goit.View;

public class InputString {
    private String inputString;

    public InputString(String inputString) {
        this.inputString = inputString;
    }

    public void validateParameters(String command) {
        int commandLength = getParametersSize(command);
        int inputLength = getLength();
        if (inputLength != commandLength) {
            String message = String.format("Invalid number of parameters separated by |, expected %s, but was %s"
                    , commandLength, inputLength);
            throw new IllegalArgumentException(message);
        }
    }

    public int getLength() {
        return getParametersSize(inputString);
    }

    public String[] getParameters() {
        return inputString.split("\\|");
    }

    private int getParametersSize(String command) {
        return command.split("\\|").length;
    }

}
