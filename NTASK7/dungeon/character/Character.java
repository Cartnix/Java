package dungeon.character;

import dungeon.strategy.AttackStrategy;
import dungeon.observer.Observer;
import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int attack;
    protected int defense;
    protected AttackStrategy attackStrategy;
    protected List<Observer> observers = new ArrayList<>();

    public Character(String name, int health, int attack, int defense) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.attack = attack;
        this.defense = defense;
    }

    public void setAttackStrategy(AttackStrategy strategy) {
        this.attackStrategy = strategy;
    }

    public int performAttack() {
        return attackStrategy.execute(attack);
    }

    public void takeDamage(int damage) {
        int actualDamage = Math.max(0, damage - defense);
        health -= actualDamage;
        notifyObservers();
        if (health <= 0) {
            health = 0;
        }
    }

    public void heal(int amount) {
        health = Math.min(maxHealth, health + amount);
        notifyObservers();
    }

    public void increaseAttack(int amount) {
        attack += amount;
        notifyObservers();
    }

    public void increaseDefense(int amount) {
        defense += amount;
        notifyObservers();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    protected void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public boolean isAlive() {
        return health > 0;
    }
}