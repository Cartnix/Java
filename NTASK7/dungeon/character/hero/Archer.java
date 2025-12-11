package dungeon.character.hero;

import dungeon.strategy.RangedAttack;

public class Archer extends Hero {
    public Archer(String name) {
        super(name, 120, 28, 7);
        setAttackStrategy(new RangedAttack());
    }
}