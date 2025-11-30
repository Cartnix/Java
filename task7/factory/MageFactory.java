package factory;

import character.Hero;
import character.Mage;

public class MageFactory extends CharacterFactory {
    @Override
    public Hero createHero(String name) {
        return new Mage(name);
    }
}