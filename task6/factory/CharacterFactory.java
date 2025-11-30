package factory;

import character.Character;

public abstract class CharacterFactory {
    public abstract Character createCharacter(String name);
}