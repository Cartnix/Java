package dungeon.item.decorator;

import dungeon.item.Item;
import dungeon.character.hero.Hero;

public class GreaterPotion extends ItemDecorator {
    public GreaterPotion(Item item) {
        super(item);
    }

    @Override
    public void apply(Hero hero) {
        super.apply(hero);
        hero.heal(20);
        System.out.println("Greater effect: Additional 20 HP restored!");
    }

    @Override
    public String getName() {
        return "Greater " + super.getName();
    }
}