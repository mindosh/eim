package mk.ukim.finki.wp.eimtlabaratoriska.model.exception;

public class AccommodationNotFoundException extends RuntimeException {
    public AccommodationNotFoundException(Long id) {
        super("The accommodation with id "+id+" was not found.");
    }
}
