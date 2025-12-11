// src/main/java/com/dungeon/exception/LowHealthException.java
package dungeon.exception;

public class LowHealthException extends Exception {
    public LowHealthException(String message) {
        super(message);
    }
}