package strategy;

import character.Character;
import monster.Monster;
import java.util.Random;

public class RangedAttack implements AttackStrategy {
    @Override
    public int attack(Character attacker, Monster target) {
        Random random = new Random();
        boolean critical = random.nextInt(100) < 25;
        int damage = critical ? 25 + attacker.getAttackPower() : 12 + attacker.getAttackPower();
        if (critical) {
            System.out.println(attacker.getName() + " shoots an arrow - CRITICAL HIT!");
        } else {
            System.out.println(attacker.getName() + " shoots an arrow!");
        }
        return damage;
    }
    
    @Override
    public int attack(Monster attacker, Character target) {
        int damage = 8;
        System.out.println(attacker.getName() + " shoots!");
        return damage;
    }
}