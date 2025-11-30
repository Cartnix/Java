package strategy;

import character.Character;

public class MagicAttack implements AttackStrategy {
    @Override
    public void attack(Character attacker, Character enemy) {
        int damage = 20;
        int selfDamage = 5;
        enemy.takeDamage(damage);
        attacker.takeDamage(selfDamage);
        attacker.notifyObservers(attacker.getName() + " применил магию на " + damage + " урона (но потерял " + selfDamage + " HP).");
    }
}