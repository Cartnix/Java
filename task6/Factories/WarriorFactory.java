package factories;

import characters.Character;
import characters.Warrior;

public class WarriorFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name) {
        return new Warrior(name);
    }
}
