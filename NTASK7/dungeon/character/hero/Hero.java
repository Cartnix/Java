package dungeon.character.hero;

import dungeon.character.Character;
import dungeon.item.Item;
import dungeon.exception.InventoryFullException;
import java.util.ArrayList;
import java.util.List;

public class Hero extends Character {
    private List<Item> inventory;
    private static final int MAX_INVENTORY_SIZE = 10;

    public Hero(String name, int health, int attack, int defense) {
        super(name, health, attack, defense);
        this.inventory = new ArrayList<>();
    }

    public void addItem(Item item) throws InventoryFullException {
        if (inventory.size() >= MAX_INVENTORY_SIZE) {
            throw new InventoryFullException("Inventory is full! Cannot add more items.");
        }
        inventory.add(item);
    }

    public void useItem(int index) {
        if (index >= 0 && index < inventory.size()) {
            Item item = inventory.remove(index);
            item.apply(this);
        }
    }

    public List<Item> getInventory() {
        return new ArrayList<>(inventory);
    }

    public int getInventorySize() {
        return inventory.size();
    }
}