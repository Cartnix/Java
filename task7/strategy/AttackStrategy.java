package strategy;

import character.Character;
import monster.Monster;

public interface AttackStrategy {
    int attack(Character attacker, Monster target);
    int attack(Monster attacker, Character target);
}