package strategy;

import character.Character;

public class MeleeAttack implements AttackStrategy {
    @Override
    public void attack(Character attacker, Character enemy) {
        int damage = 15;
        enemy.takeDamage(damage);
        attacker.notifyObservers(attacker.getName() + " нанёс удар мечом на " + damage + " урона.");
    }
}