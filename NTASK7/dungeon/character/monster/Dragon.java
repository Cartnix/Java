package dungeon.character.monster;

import dungeon.exception.DragonFireException;

public class Dragon extends Monster {
    public Dragon() {
        super("Dragon", 200, 35, 15);
    }

    @Override
    public int getReward() {
        return 100;
    }

    @Override
    public int performAttack() {
        if (Math.random() < 0.3) {
            throw new DragonFireException("Dragon unleashes devastating fire breath!");
        }
        return super.performAttack();
    }
}