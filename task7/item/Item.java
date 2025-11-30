package item;

import character.Hero;

public interface Item {
    void apply(Hero hero);
    String getName();
    String getDescription();
}