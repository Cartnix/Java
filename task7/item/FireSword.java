package item;

import character.Hero;

public class FireSword extends ItemDecorator {
    public FireSword(Item item) {
        super(item);
    }
    
    @Override
    public void apply(Hero hero) {
        super.apply(hero);
        hero.increaseAttack(10);
        System.out.println("🔥 Fire Sword! Additional +10 to attack!");
    }
    
    @Override
    public String getName() {
        return "Fire " + super.getName();
    }
    
    @Override
    public String getDescription() {
        return super.getDescription() + " + 10 damage (FIRE)";
    }
}
