package character;

import strategy.AttackStrategy;
import item.Item;
import exception.InventoryFullException;
import java.util.ArrayList;
import java.util.List;

public abstract class Hero extends Character {
    protected List<Item> inventory;
    protected int maxInventorySize;

    public Hero(String name, int health, int attackPower, int defense, AttackStrategy strategy) {
        super(name, health, attackPower, defense, strategy);
        this.inventory = new ArrayList<>();
        this.maxInventorySize = 5;
    }

    public void addItem(Item item) throws InventoryFullException {
        if (inventory.size() >= maxInventorySize) {
            throw new InventoryFullException("Inventory full! Maximum items: " + maxInventorySize);
        }
        inventory.add(item);
        notifyEvent(name + " picked up: " + item.getName());
    }

    public void useItem(int index) {
        if (index >= 0 && index < inventory.size()) {
            Item item = inventory.remove(index);
            item.apply(this);
        }
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        System.out.println("Inventory:");
        for (int i = 0; i < inventory.size(); i++) {
            Item it = inventory.get(i);
            System.out.println((i + 1) + ". " + it.getName() + " - " + it.getDescription());
        }
    }
}