package dungeon.game;

import dungeon.character.hero.Hero;
import dungeon.character.monster.Monster;
import dungeon.factory.CharacterFactory;
import dungeon.factory.GameCharacterFactory;
import dungeon.factory.ItemFactory;
import dungeon.item.Item;
import dungeon.item.Sword;
import dungeon.battle.BattleTemplate;
import dungeon.battle.StandardBattle;
import dungeon.observer.LogObserver;
import dungeon.observer.UIObserver;
import dungeon.exception.LowHealthException;
import dungeon.exception.InventoryFullException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Game {
    private Hero hero;
    private List<Monster> monsters;
    private Map<String, Integer> leaderboard;
    private CharacterFactory characterFactory;
    private ItemFactory itemFactory;
    private BattleTemplate battle;
    private int victories;

    public Game() {
        this.monsters = new ArrayList<>();
        this.leaderboard = new HashMap<>();
        this.characterFactory = new GameCharacterFactory();
        this.itemFactory = new ItemFactory();
        this.battle = new StandardBattle();
        this.victories = 0;
    }

    public void start(String heroName, String heroType) {
        hero = characterFactory.createHero(heroName, heroType);
        
        LogObserver logObserver = new LogObserver();
        UIObserver uiObserver = new UIObserver();
        hero.addObserver(logObserver);
        hero.addObserver(uiObserver);

        System.out.println("Game started! Hero: " + hero.getName() + 
                         " (Type: " + heroType + ")");
        System.out.println("HP: " + hero.getHealth() + 
                         ", ATK: " + hero.getAttack() + 
                         ", DEF: " + hero.getDefense());

        generateMonsters(5);
        giveStartingItems();
    }

    private void generateMonsters(int count) {
        for (int i = 0; i < count; i++) {
            monsters.add(characterFactory.createMonster());
        }
        System.out.println("\n" + count + " monsters have appeared!");
    }

    private void giveStartingItems() {
        try {
            Item potion = itemFactory.createRandomItem();
            hero.addItem(potion);
            
            Item enhancedItem = itemFactory.createEnhancedItem(new Sword());
            hero.addItem(enhancedItem);
            
            System.out.println("\nStarting items added to inventory.");
        } catch (InventoryFullException e) {
            System.out.println(e.getMessage());
        }
    }

    public void playRound() {
        if (monsters.isEmpty()) {
            System.out.println("\nAll monsters defeated! You win!");
            updateLeaderboard();
            return;
        }

        Iterator<Monster> iterator = monsters.iterator();
        if (iterator.hasNext()) {
            Monster monster = iterator.next();
            
            try {
                battle.executeBattle(hero, monster);
                
                if (hero.isAlive()) {
                    iterator.remove();
                    victories++;
                    
                    if (Math.random() < 0.5) {
                        Item item = itemFactory.createRandomItem();
                        try {
                            hero.addItem(item);
                            System.out.println("Found item: " + item.getName());
                        } catch (InventoryFullException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                } else {
                    System.out.println("\nGame Over!");
                    updateLeaderboard();
                }
                
            } catch (LowHealthException e) {
                System.out.println(e.getMessage());
                System.out.println("Game Over!");
                updateLeaderboard();
            }
        }
    }

    public void useInventoryItem(int index) {
        try {
            if (index < 0 || index >= hero.getInventorySize()) {
                System.out.println("Invalid item index!");
                return;
            }
            hero.useItem(index);
        } catch (Exception e) {
            System.out.println("Error using item: " + e.getMessage());
        }
    }

    public void displayInventory() {
        System.out.println("\nInventory:");
        List<Item> inventory = hero.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println(i + ": " + inventory.get(i).getName());
        }
    }

    public void displayRemainingMonsters() {
        System.out.println("\nRemaining monsters: " + monsters.size());
        for (Monster monster : monsters) {
            System.out.println("- " + monster.getName() + " (HP: " + monster.getHealth() + ")");
        }
    }

    private void updateLeaderboard() {
        leaderboard.put(hero.getName(), victories);
        displayLeaderboard();
    }

    public void displayLeaderboard() {
        System.out.println("\n=== Leaderboard ===");
        leaderboard.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " victories"));
    }

    public boolean isGameActive() {
        return hero != null && hero.isAlive() && !monsters.isEmpty();
    }

    public Hero getHero() {
        return hero;
    }
}