package character;

import strategy.MagicAttack;

public class Mage extends Hero {
    public Mage(String name) {
        super(name, 80, 10, 3, new MagicAttack());
    }
}