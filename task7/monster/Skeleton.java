package monster;

import strategy.RangedAttack;

public class Skeleton extends Monster {
    public Skeleton() {
        super("Skeleton", 40, 7, new RangedAttack());
    }
}