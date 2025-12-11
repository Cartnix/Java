package dungeon.character.hero;

import dungeon.strategy.MagicAttack;

public class Mage extends Hero {
    public Mage(String name) {
        super(name, 100, 30, 5);
        setAttackStrategy(new MagicAttack());
    }
}