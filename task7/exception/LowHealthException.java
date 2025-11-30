package exception;

public class LowHealthException extends Exception {
    public LowHealthException(String message) {
        super(message);
    }
}