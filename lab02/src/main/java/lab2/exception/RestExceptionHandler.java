package lab2.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import lab2.model.CustomRestError;

@ControllerAdvice
public class RestExceptionHandler {

   @ExceptionHandler(Exception.class)
   public ResponseEntity<CustomRestError> handleAnyException(Exception ex, WebRequest request) {
       CustomRestError errorMessage = new CustomRestError(new Date(), ex.getMessage(), request.getDescription(false));
       return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
   }

   @ExceptionHandler({ProductNotFoundException.class, UserNotFoundException.class,
	   UserAlreadyExistsException.class})
   public ResponseEntity<CustomRestError> notFound(Exception ex, WebRequest request) {
       CustomRestError errorMessage = new CustomRestError(new Date(), ex.getMessage(), request.getDescription(false));
       return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.NOT_FOUND);
   }
}
