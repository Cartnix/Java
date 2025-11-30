package character;

import strategy.MagicAttack;

public class Mage extends Character {
    public Mage(String name) {
        super(name, 80, new MagicAttack());
    }
}