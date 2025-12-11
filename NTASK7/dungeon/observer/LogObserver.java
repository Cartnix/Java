package dungeon.observer;

import dungeon.character.Character;

public class LogObserver implements Observer {
    @Override
    public void update(Character character) {
        System.out.println("[LOG] " + character.getName() + " stats updated - HP: " + 
                         character.getHealth() + "/" + character.getMaxHealth() + 
                         ", ATK: " + character.getAttack() + 
                         ", DEF: " + character.getDefense());
    }
}