package character;

import strategy.AttackStrategy;
import observer.GameObserver;
import exception.LowHealthException;
import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int attackPower;
    protected int defense;
    protected AttackStrategy attackStrategy;
    protected List<GameObserver> observers = new ArrayList<>();

    public Character(String name, int health, int attackPower, int defense, AttackStrategy strategy) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.attackPower = attackPower;
        this.defense = defense;
        this.attackStrategy = strategy;
    }

    public void takeDamage(int damage) throws LowHealthException {
        int oldHp = health;
        int actualDamage = Math.max(1, damage - defense);
        health -= actualDamage;
        
        if (health < 0) health = 0;
        
        notifyHealthChanged(oldHp, health);
        
        if (health <= 0) {
            throw new LowHealthException(name + " has died!");
        }
    }

    public void heal(int amount) {
        int oldHp = health;
        health = Math.min(health + amount, maxHealth);
        notifyHealthChanged(oldHp, health);
    }

    public void increaseAttack(int amount) {
        attackPower += amount;
        notifyAttackChanged();
    }

    public void increaseDefense(int amount) {
        defense += amount;
        notifyDefenseChanged();
    }

    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    protected void notifyHealthChanged(int oldHp, int newHp) {
        for (GameObserver observer : observers) {
            observer.onHealthChanged(name, oldHp, newHp);
        }
    }

    protected void notifyAttackChanged() {
        for (GameObserver observer : observers) {
            observer.onAttackChanged(name, attackPower);
        }
    }

    protected void notifyDefenseChanged() {
        for (GameObserver observer : observers) {
            observer.onDefenseChanged(name, defense);
        }
    }

    protected void notifyEvent(String event) {
        for (GameObserver observer : observers) {
            observer.onEvent(event);
        }
    }

    public boolean isAlive() {
        return health > 0;
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getMaxHealth() { return maxHealth; }
    public int getAttackPower() { return attackPower; }
    public int getDefense() { return defense; }
    public AttackStrategy getAttackStrategy() { return attackStrategy; }
}