package strategy;

import character.Character;
import monster.Monster;

public class MeleeAttack implements AttackStrategy {
    @Override
    public int attack(Character attacker, Monster target) {
        int damage = 15 + attacker.getAttackPower();
        System.out.println(attacker.getName() + " strikes with a sword!");
        return damage;
    }
    
    @Override
    public int attack(Monster attacker, Character target) {
        int damage = 10;
        System.out.println(attacker.getName() + " hits!");
        return damage;
    }
}