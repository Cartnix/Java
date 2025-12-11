package dungeon.item.decorator;

import dungeon.item.Item;
import dungeon.character.hero.Hero;

public class FireSword extends ItemDecorator {
    public FireSword(Item item) {
        super(item);
    }

    @Override
    public void apply(Hero hero) {
        super.apply(hero);
        hero.increaseAttack(5);
        System.out.println("Fire enchantment: Additional 5 attack!");
    }

    @Override
    public String getName() {
        return "Fire " + super.getName();
    }
}