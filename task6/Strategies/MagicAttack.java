package strategies;

import characters.Character;

public class MagicAttack implements AttackStrategy {
    @Override
    public void attack(Character attacker, Character enemy) {
        int damage = 20;
        int selfDamage = 5;
        enemy.takeDamage(damage);
        attacker.takeDamage(selfDamage);
        attacker.notifyObservers(attacker.getName() + " магией ударил " + enemy.getName() + " на " + damage + " урона и получил " + selfDamage + " урона сам.");
    }
}
