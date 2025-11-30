package monster;

import strategy.MeleeAttack;

public class Goblin extends Monster {
    public Goblin() {
        super("Goblin", 30, 5, new MeleeAttack());
    }
}