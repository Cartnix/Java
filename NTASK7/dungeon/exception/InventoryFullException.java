// src/main/java/com/dungeon/exception/InventoryFullException.java
package dungeon.exception;

public class InventoryFullException extends Exception {
    public InventoryFullException(String message) {
        super(message);
    }
}