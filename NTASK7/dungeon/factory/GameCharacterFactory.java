package dungeon.factory;

import dungeon.character.hero.Hero;
import dungeon.character.hero.Warrior;
import dungeon.character.hero.Mage;
import dungeon.character.hero.Archer;
import dungeon.character.monster.Monster;
import dungeon.character.monster.Goblin;
import dungeon.character.monster.Skeleton;
import dungeon.character.monster.Dragon;
import java.util.Random;

public class GameCharacterFactory implements CharacterFactory {
    private Random random = new Random();

    @Override
    public Hero createHero(String name, String type) {
        switch (type.toLowerCase()) {
            case "warrior":
                return new Warrior(name);
            case "mage":
                return new Mage(name);
            case "archer":
                return new Archer(name);
            default:
                return new Warrior(name);
        }
    }

    @Override
    public Monster createMonster() {
        int choice = random.nextInt(3);
        switch (choice) {
            case 0:
                return new Goblin();
            case 1:
                return new Skeleton();
            case 2:
                return new Dragon();
            default:
                return new Goblin();
        }
    }
}