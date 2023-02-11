package co.develhope.mongoDb.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super("User not found");
    }
}
