package Exceptions;

public class DeleteFailedException extends Exception{
    public DeleteFailedException(String message) {
        super(message);
    }
}