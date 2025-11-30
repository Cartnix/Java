package character;

import strategy.MeleeAttack;

public class Warrior extends Hero {
    public Warrior(String name) {
        super(name, 120, 5, 10, new MeleeAttack());
    }
}