package item;

import character.Hero;

public class GreaterPotion extends ItemDecorator {
    public GreaterPotion(Item item) {
        super(item);
    }
    
    @Override
    public void apply(Hero hero) {
        super.apply(hero);
        hero.heal(30);
        System.out.println("Enhanced potion! Additional 30 HP restored.");
    }
    
    @Override
    public String getName() {
        return "Greater " + super.getName();
    }
    
    @Override
    public String getDescription() {
        return super.getDescription() + " + 30 HP";
    }
}
