package strategy;

import character.Character;

public class BerserkerAttack implements AttackStrategy {
    @Override
    public void attack(Character attacker, Character enemy) {
        int damage = 22;
        int selfDamage = 3;
        enemy.takeDamage(damage);
        attacker.takeDamage(selfDamage);
        attacker.notifyObservers(attacker.getName() + " впал в ЯРОСТЬ и нанёс " + damage + " урона (потеряв " + selfDamage + " HP).");
    }
}