package ua.goit.exeption;

public class ExitException extends RuntimeException{
    public ExitException(String message) {
        super(message);
    }
}
