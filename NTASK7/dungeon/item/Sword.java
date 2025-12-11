package dungeon.item;

import dungeon.character.hero.Hero;

public class Sword implements Item {
    protected int attackBonus;
    protected String name;

    public Sword() {
        this.attackBonus = 10;
        this.name = "Sword";
    }

    @Override
    public void apply(Hero hero) {
        hero.increaseAttack(attackBonus);
        System.out.println(hero.getName() + " equipped " + name + "! Attack increased by " + attackBonus + "!");
    }

    @Override
    public String getName() {
        return name;
    }
}