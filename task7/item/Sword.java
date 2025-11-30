package item;

import character.Hero;

public class Sword implements Item {
    @Override
    public void apply(Hero hero) {
        hero.increaseAttack(5);
        System.out.println("You equip a sword. Attack increased by 5.");
    }
    
    @Override
    public String getName() {
        return "Sword";
    }
    
    @Override
    public String getDescription() {
        return "Increases attack by 5";
    }
}