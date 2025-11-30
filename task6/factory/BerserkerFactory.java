package factory;

import character.Character;
import character.Berserker;

public class BerserkerFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name) {
        return new Berserker(name);
    }
}