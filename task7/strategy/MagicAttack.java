package strategy;

import character.Character;
import monster.Monster;

public class MagicAttack implements AttackStrategy {
    @Override
    public int attack(Character attacker, Monster target) {
        int damage = 20 + attacker.getAttackPower();
        System.out.println(attacker.getName() + " uses a magic attack!");
        return damage;
    }
    
    @Override
    public int attack(Monster attacker, Character target) {
        int damage = 15;
        System.out.println(attacker.getName() + " casts magic!");
        return damage;
    }
}