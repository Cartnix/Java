package dungeon.factory;

import dungeon.item.Item;
import dungeon.item.Potion;
import dungeon.item.Sword;
import dungeon.item.Shield;
import dungeon.item.decorator.GreaterPotion;
import dungeon.item.decorator.FireSword;
import java.util.Random;

public class ItemFactory {
    private Random random = new Random();

    public Item createRandomItem() {
        int choice = random.nextInt(3);
        switch (choice) {
            case 0:
                return new Potion();
            case 1:
                return new Sword();
            case 2:
                return new Shield();
            default:
                return new Potion();
        }
    }

    public Item createEnhancedItem(Item baseItem) {
        int choice = random.nextInt(2);
        if (baseItem instanceof Potion && choice == 0) {
            return new GreaterPotion(baseItem);
        } else if (baseItem instanceof Sword && choice == 1) {
            return new FireSword(baseItem);
        }
        return baseItem;
    }
}