package factories;

import characters.Character;

public abstract class CharacterFactory {
    public abstract Character createCharacter(String name);
}
