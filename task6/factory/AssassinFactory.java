package factory;

import character.Character;
import character.Assassin;

public class AssassinFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name) {
        return new Assassin(name);
    }
}