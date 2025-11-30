package factory;

import item.*;
import java.util.Random;

public class ItemFactory {
    private static Random random = new Random();
    
    public static Item createRandomItem() {
        int type = random.nextInt(3);
        switch (type) {
            case 0: return new Potion();
            case 1: return new Sword();
            case 2: return new Shield();
            default: return new Potion();
        }
    }
    
    public static Item createEnhancedPotion() {
        return new GreaterPotion(new Potion());
    }
    
    public static Item createFireSword() {
        return new FireSword(new Sword());
    }
}