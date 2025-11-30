package character;

import strategy.MeleeAttack;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 100, new MeleeAttack());
    }
}