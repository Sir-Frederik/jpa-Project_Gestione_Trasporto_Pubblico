package team1.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("The element with id " + id + " hasn't been found yet or it doesn't exist!");
    }
}
