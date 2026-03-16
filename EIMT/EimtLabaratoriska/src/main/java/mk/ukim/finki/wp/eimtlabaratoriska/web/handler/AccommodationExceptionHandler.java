package mk.ukim.finki.wp.eimtlabaratoriska.web.handler;

import mk.ukim.finki.wp.eimtlabaratoriska.model.exception.AccommodationNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import mk.ukim.finki.eshopbackend.web.dto.ApiError;

@RestControllerAdvice
public class AccommodationExceptionHandler {
    @ExceptionHandler(AccommodationNotFoundException.class)
    public ResponseEntity<ApiError> handleAccommodationNotFoundException(AccommodationNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiError.of(HttpStatus.NOT_FOUND,ex.getMessage()));
    }
}
