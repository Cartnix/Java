package characters;

import strategies.AttackStrategy;
import observers.GameObserver;
import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    protected String name;
    protected int health;
    protected AttackStrategy attackStrategy;
    protected List<GameObserver> observers = new ArrayList<>();

    public Character(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public void setAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }

    public void performAttack(Character enemy) {
        if (attackStrategy != null) {
            attackStrategy.attack(this, enemy);
        }
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
        for (GameObserver o : observers) {
            o.onEvent(event);
        }
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
}
