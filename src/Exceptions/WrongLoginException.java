package Exceptions;

public class WrongLoginException extends Exception {
    public WrongLoginException() {
        super();
    }

    public WrongLoginException(String message) {
        super(message);
    }

    public WrongLoginException(String message, Throwable t) {
        super(message, t);
    }

    public WrongLoginException(Throwable t) {
        super(t);
    }
}