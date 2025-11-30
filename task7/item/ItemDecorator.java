package item;

import character.Hero;

public abstract class ItemDecorator implements Item {
    protected Item decoratedItem;
    
    public ItemDecorator(Item item) {
        this.decoratedItem = item;
    }
    
    @Override
    public void apply(Hero hero) {
        decoratedItem.apply(hero);
    }
    
    @Override
    public String getName() {
        return decoratedItem.getName();
    }
    
    @Override
    public String getDescription() {
        return decoratedItem.getDescription();
    }
}