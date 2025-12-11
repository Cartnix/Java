package dungeon.strategy;

public class RangedAttack implements AttackStrategy {
    @Override
    public int execute(int baseDamage) {
        return (int) (baseDamage * 1.1);
    }
}