package exception;

public class DragonFireException extends Exception {
    private int fireDamage;
    
    public DragonFireException(String message, int fireDamage) {
        super(message);
        this.fireDamage = fireDamage;
    }
    
    public int getFireDamage() {
        return fireDamage;
    }
}