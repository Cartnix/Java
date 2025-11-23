package strategies;

import characters.Character;

public class MeleeAttack implements AttackStrategy {
    @Override
    public void attack(Character attacker, Character enemy) {
        int damage = 15;
        enemy.takeDamage(damage);
        attacker.notifyObservers(attacker.getName() + " ударил " + enemy.getName() + " на " + damage + " урона.");
    }
}
