package dungeon.item;

import dungeon.character.hero.Hero;

public interface Item {
    void apply(Hero hero);
    String getName();
}