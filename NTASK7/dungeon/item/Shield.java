package dungeon.item;

import dungeon.character.hero.Hero;

public class Shield implements Item {
    protected int defenseBonus;
    protected String name;

    public Shield() {
        this.defenseBonus = 8;
        this.name = "Shield";
    }

    @Override
    public void apply(Hero hero) {
        hero.increaseDefense(defenseBonus);
        System.out.println(hero.getName() + " equipped " + name + "! Defense increased by " + defenseBonus + "!");
    }

    @Override
    public String getName() {
        return name;
    }
}