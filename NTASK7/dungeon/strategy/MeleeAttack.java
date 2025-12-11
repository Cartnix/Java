package dungeon.strategy;

public class MeleeAttack implements AttackStrategy {
    @Override
    public int execute(int baseDamage) {
        return (int) (baseDamage * 1.0);
    }
}