package factory;

import character.Hero;
import character.Archer;

public class ArcherFactory extends CharacterFactory {
    @Override
    public Hero createHero(String name) {
        return new Archer(name);
    }
}
