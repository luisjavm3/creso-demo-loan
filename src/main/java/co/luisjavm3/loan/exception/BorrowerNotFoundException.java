package co.luisjavm3.loan.exception;

public class BorrowerNotFoundException extends RuntimeException {
    public BorrowerNotFoundException(String message) {
        super(message);
    }
}
