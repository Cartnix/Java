// src/main/java/com/dungeon/item/decorator/ItemDecorator.java
package dungeon.item.decorator;

import dungeon.item.Item;
import dungeon.character.hero.Hero;

public abstract class ItemDecorator implements Item {
    protected Item decoratedItem;

    public ItemDecorator(Item item) {
        this.decoratedItem = item;
    }

    @Override
    public void apply(Hero hero) {
        decoratedItem.apply(hero);
    }

    @Override
    public String getName() {
        return decoratedItem.getName();
    }
}