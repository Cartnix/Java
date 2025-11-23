package characters;

import strategies.BowAttack;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 90);
        this.attackStrategy = new BowAttack();
    }
}
