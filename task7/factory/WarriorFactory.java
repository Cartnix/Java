package factory;

import character.Hero;
import character.Warrior;

public class WarriorFactory extends CharacterFactory {
    @Override
    public Hero createHero(String name) {
        return new Warrior(name);
    }
}