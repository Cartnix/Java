 
import character.*;
import monster.*;
import factory.*;
import item.*;
import battle.*;
import observer.*;
import exception.*;
import java.util.*;

public class DungeonGame {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, Integer> leaderboard = new HashMap<>();
    private static GameLog gameLog = new GameLog();
    private static UIObserver uiObserver = new UIObserver();
    
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   🏰 WELCOME TO THE DUNGEON! 🏰         ║");
        System.out.println("╚════════════════════════════════════════╝\n");
        
        
        Hero hero = createHero();
        hero.addObserver(gameLog);
        hero.addObserver(uiObserver);
        
        
        List<Monster> monsters = new ArrayList<>();
        monsters.add(MonsterFactory.createRandomMonster());
        monsters.add(MonsterFactory.createRandomMonster());
        monsters.add(MonsterFactory.createBoss());
        
        System.out.println("\n🗺️  You enter the dungeon...");
        System.out.println("Ahead of you are " + monsters.size() + " rooms with monsters!\n");
        
        
        Iterator<Monster> iterator = monsters.iterator();
        int roomNumber = 1;
        int victories = 0;
        
        while (iterator.hasNext() && hero.isAlive()) {
            Monster monster = iterator.next();
            
            System.out.println("\n" + "═".repeat(50));
            System.out.println("🚪 ROOM " + roomNumber);
            System.out.println("═".repeat(50));
            System.out.println("You encounter " + monster.getName() + " in the room!");
            
            
            if (new Random().nextInt(100) < 60) {
                try {
                    Item item;
                    int itemChance = new Random().nextInt(100);
                    
                    
                    if (itemChance < 10) {
                        item = ItemFactory.createFireSword();
                    } 
                    
                    else if (itemChance < 20) {
                        item = ItemFactory.createEnhancedPotion();
                    } 
                    
                    else {
                        item = ItemFactory.createRandomItem();
                    }
                    
                    System.out.println("💎 You found: " + item.getName());
                    hero.addItem(item);
                    
                } catch (InventoryFullException e) {
                    System.out.println(e.getMessage());
                }
            }
            
            
            System.out.println("\n👤 Your stats:");
            System.out.println("   ❤️  HP: " + hero.getHealth() + "/" + hero.getMaxHealth());
            System.out.println("   ⚔️  Attack: " + hero.getAttackPower());
            System.out.println("   🛡️  Defense: " + hero.getDefense());
            System.out.println("   📦 Items in inventory: " + hero.getInventory().size() + "/5");
            
            
            BattleTemplate battle = new StandardBattle();
            battle.fight(hero, monster);
            
            if (!hero.isAlive()) {
                break;
            }
            
            victories++;
            roomNumber++;
            
            
            try {
                System.out.println("\nMoving to the next room...");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        
        System.out.println("\n" + "═".repeat(50));
        System.out.println("🏆 ADVENTURE SUMMARY");
        System.out.println("═".repeat(50));
        
        if (hero.isAlive() && victories == 3) {
            System.out.println("🎉🎉🎉 AMAZING! You cleared the entire dungeon! 🎉🎉🎉");
            System.out.println("✨ Monsters defeated: " + victories);
            System.out.println("❤️  Remaining HP: " + hero.getHealth() + "/" + hero.getMaxHealth());
            System.out.println("⚔️  Final attack: " + hero.getAttackPower());
            System.out.println("🛡️  Final defense: " + hero.getDefense());
            
            
            leaderboard.put(hero.getName(), leaderboard.getOrDefault(hero.getName(), 0) + victories);
        } else if (hero.isAlive()) {
            System.out.println("✅ You escaped the dungeon!");
            System.out.println("⚔️  Monsters defeated: " + victories);
            leaderboard.put(hero.getName(), leaderboard.getOrDefault(hero.getName(), 0) + victories);
        } else {
            System.out.println("💀 You died in room " + (roomNumber - 1));
            System.out.println("⚔️  Monsters defeated: " + victories);
            
            
            leaderboard.put(hero.getName(), leaderboard.getOrDefault(hero.getName(), 0) + victories);
        }
        
        
        showLeaderboard();
        
        scanner.close();
    }
    
    
    private static Hero createHero() {
        System.out.println("Choose a hero class:");
        System.out.println("1. 🗡️  Warrior (HP: 120, Defense: 10, Melee attack)");
        System.out.println("2. 🔮 Mage (HP: 80, Defense: 3, Magic attack)");
        System.out.println("3. 🏹 Archer (HP: 100, Defense: 5, Ranged attack with crits)");
        System.out.print("\nYour choice: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter hero name: ");
        String name = scanner.nextLine();
        
        CharacterFactory factory;
        switch (choice) {
            case 1: 
                factory = new WarriorFactory(); 
                break;
            case 2: 
                factory = new MageFactory(); 
                break;
            case 3: 
                factory = new ArcherFactory(); 
                break;
            default: 
                System.out.println("⚠️  Invalid choice! Creating a Warrior by default.");
                factory = new WarriorFactory();
        }
        
        Hero hero = factory.createHero(name);
        System.out.println("\n✨ Hero created: " + hero.getName());
        System.out.println("   ❤️  HP: " + hero.getHealth());
        System.out.println("   ⚔️  Attack: " + hero.getAttackPower());
        System.out.println("   🛡️  Defense: " + hero.getDefense());
        
        return hero;
    }
    
    
    private static void showLeaderboard() {
        System.out.println("\n" + "═".repeat(50));
        System.out.println("📊 PLAYER LEADERBOARD");
        System.out.println("═".repeat(50));
        
        if (leaderboard.isEmpty()) {
            System.out.println("Leaderboard is empty! Be the first!");
            return;
        }
        
        
        List<Map.Entry<String, Integer>> sortedLeaderboard = new ArrayList<>(leaderboard.entrySet());
        sortedLeaderboard.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        
        int position = 1;
        for (Map.Entry<String, Integer> entry : sortedLeaderboard) {
            String medal = "";
            if (position == 1) medal = "🥇";
            else if (position == 2) medal = "🥈";
            else if (position == 3) medal = "🥉";
            else medal = "   ";
            
            System.out.println(medal + " " + position + ". " + entry.getKey() + 
                             " - " + entry.getValue() + " victories");
            position++;
        }
        
        System.out.println("═".repeat(50));
        System.out.println("\n🎮 Thanks for playing! See you on the next adventure! 🎮");
    }
}