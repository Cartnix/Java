package monster;

import strategy.AttackStrategy;
import exception.LowHealthException;

public abstract class Monster {
    protected String name;
    protected int health;
    protected int attackPower;
    protected AttackStrategy attackStrategy;

    public Monster(String name, int health, int attackPower, AttackStrategy strategy) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.attackStrategy = strategy;
    }

    public void takeDamage(int damage) throws LowHealthException {
        health -= damage;
        if (health < 0) health = 0;
        
        if (health <= 0) {
            throw new LowHealthException(name + " defeated!");
        }
    }

    public boolean isAlive() {
        return health > 0;
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getAttackPower() { return attackPower; }
    public AttackStrategy getAttackStrategy() { return attackStrategy; }
}