package strategies;

import characters.Character;
import java.util.Random;

public class BowAttack implements AttackStrategy {
    private Random random = new Random();

    @Override
    public void attack(Character attacker, Character enemy) {
        int damage = 10;
        boolean crit = random.nextInt(100) < 25; // 25% шанс крита
        if (crit) damage *= 2;
        enemy.takeDamage(damage);
        attacker.notifyObservers(attacker.getName() + " стрелой ударил " + enemy.getName() + " на " + damage + " урона" + (crit ? " (крит!)" : ""));
    }
}
