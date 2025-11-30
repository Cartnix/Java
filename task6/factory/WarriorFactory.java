package factory;

import character.Character;
import character.Warrior;

public class WarriorFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name) {
        return new Warrior(name);
    }
}