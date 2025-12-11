package dungeon.item;

import dungeon.character.hero.Hero;

public class Potion implements Item {
    protected int healAmount;
    protected String name;

    public Potion() {
        this.healAmount = 30;
        this.name = "Potion";
    }

    @Override
    public void apply(Hero hero) {
        hero.heal(healAmount);
        System.out.println(hero.getName() + " used " + name + " and restored " + healAmount + " HP!");
    }

    @Override
    public String getName() {
        return name;
    }
}