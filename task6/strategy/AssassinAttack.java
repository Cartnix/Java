package strategy;

import character.Character;
import java.util.Random;

public class AssassinAttack implements AttackStrategy {
    @Override
    public void attack(Character attacker, Character enemy) {
        Random random = new Random();
        boolean backstab = random.nextInt(100) < 40;
        int damage = backstab ? 30 : 12;
        enemy.takeDamage(damage);
        if (backstab) {
            attacker.notifyObservers(attacker.getName() + " нанёс УДАР В СПИНУ на " + damage + " урона!");
        } else {
            attacker.notifyObservers(attacker.getName() + " нанёс удар кинжалом на " + damage + " урона.");
        }
    }
}