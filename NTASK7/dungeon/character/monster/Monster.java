package dungeon.character.monster;

import dungeon.character.Character;
import dungeon.strategy.MeleeAttack;

public abstract class Monster extends Character {
    public Monster(String name, int health, int attack, int defense) {
        super(name, health, attack, defense);
        setAttackStrategy(new MeleeAttack());
    }

    public abstract int getReward();
}