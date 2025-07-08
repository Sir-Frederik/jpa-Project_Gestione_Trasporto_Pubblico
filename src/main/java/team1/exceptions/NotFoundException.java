package team1.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("L'evento con id " + id + " non è stato trovato o non esiste ancora!");
    }
}
