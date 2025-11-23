package characters;

import strategies.MeleeAttack;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 100);
        this.attackStrategy = new MeleeAttack();
    }
}
