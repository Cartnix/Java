package dungeon.strategy;

public class MagicAttack implements AttackStrategy {
    @Override
    public int execute(int baseDamage) {
        return (int) (baseDamage * 1.2);
    }
}