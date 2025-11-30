package character;

import strategy.BowAttack;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 90, new BowAttack());
    }
}