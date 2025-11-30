package item;

import character.Hero;

public class Shield implements Item {
    @Override
    public void apply(Hero hero) {
        hero.increaseDefense(5);
        System.out.println("You equip a shield. Defense increased by 5.");
    }
    
    @Override
    public String getName() {
        return "Shield";
    }
    
    @Override
    public String getDescription() {
        return "Increases defense by 5";
    }
}