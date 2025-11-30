package character;

import strategy.RangedAttack;

public class Archer extends Hero {
    public Archer(String name) {
        super(name, 100, 7, 5, new RangedAttack());
    }
}