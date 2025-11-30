package character;

import strategy.AttackStrategy;
import observer.GameObserver;
import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected AttackStrategy attackStrategy;
    protected List<GameObserver> observers = new ArrayList<>();

    public Character(String name, int health, AttackStrategy attackStrategy) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.attackStrategy = attackStrategy;
    }

    public void performAttack(Character enemy) {
        attackStrategy.attack(this, enemy);
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(String event) {
        for (GameObserver observer : observers) {
            observer.onEvent(event);
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
}