package dungeon.character.hero;

import dungeon.strategy.MeleeAttack;

public class Warrior extends Hero {
    public Warrior(String name) {
        super(name, 150, 25, 10);
        setAttackStrategy(new MeleeAttack());
    }
}