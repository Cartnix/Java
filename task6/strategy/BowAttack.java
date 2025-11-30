package strategy;

import character.Character;
import java.util.Random;

public class BowAttack implements AttackStrategy {
    @Override
    public void attack(Character attacker, Character enemy) {
        Random random = new Random();
        boolean criticalHit = random.nextInt(100) < 30;
        int damage = criticalHit ? 25 : 10;
        enemy.takeDamage(damage);
        if (criticalHit) {
            attacker.notifyObservers(attacker.getName() + " выстрелил из лука КРИТИЧЕСКИ на " + damage + " урона!");
        } else {
            attacker.notifyObservers(attacker.getName() + " выстрелил из лука на " + damage + " урона.");
        }
    }
}