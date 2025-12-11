package dungeon.factory;

import dungeon.character.hero.Hero;
import dungeon.character.monster.Monster;

public interface CharacterFactory {
    Hero createHero(String name, String type);
    Monster createMonster();
}