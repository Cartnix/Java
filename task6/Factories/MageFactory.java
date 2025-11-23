package factories;

import characters.Character;
import characters.Mage;

public class MageFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name) {
        return new Mage(name);
    }
}
