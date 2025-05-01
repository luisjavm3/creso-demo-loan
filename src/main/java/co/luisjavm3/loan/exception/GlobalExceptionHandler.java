package co.luisjavm3.loan.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BorrowerNotFoundException.class)
    public ResponseEntity<?> handleBorrowerNotFoundException(BorrowerNotFoundException ex) {
        var result = GlobalErrorResponse.builder()
                .ErrorName(ex.getClass().toString())
                .message(ex.getMessage()).build();

        return ResponseEntity.badRequest().body(result);
    }
}
