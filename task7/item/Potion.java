package item;

import character.Hero;

public class Potion implements Item {
    @Override
    public void apply(Hero hero) {
        hero.heal(20);
        System.out.println("You drink the potion. HP restored by 20.");
    }
    
    @Override
    public String getName() {
        return "Health Potion";
    }
    
    @Override
    public String getDescription() {
        return "Restores 20 HP";
    }
}