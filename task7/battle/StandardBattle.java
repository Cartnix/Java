package battle;

import character.Hero;
import monster.Monster;
import exception.LowHealthException;

public class StandardBattle extends BattleTemplate {
    
    @Override
    protected void battleStart(Hero hero, Monster monster) {
        System.out.println("\n⚔️  THE BATTLE BEGINS!");
        System.out.println(hero.getName() + " [HP: " + hero.getHealth() + "] VS " + 
                          monster.getName() + " [HP: " + monster.getHealth() + "]\n");
    }
    
    @Override
    protected void heroTurn(Hero hero, Monster monster) throws LowHealthException {
        System.out.println("\n> Choose an action:");
        System.out.println("1. Attack");
        System.out.println("2. Use item");
        System.out.println("3. Run");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1:
                int damage = hero.getAttackStrategy().attack(hero, monster);
                monster.takeDamage(damage);
                System.out.println(monster.getName() + " HP: " + monster.getHealth());
                break;
            case 2:
                hero.showInventory();
                if (!hero.getInventory().isEmpty()) {
                    System.out.print("Choose an item (number): ");
                    int itemIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    hero.useItem(itemIndex);
                }
                break;
            case 3:
                System.out.println("🏃 You fled the battle!");
                throw new LowHealthException("Fled the battle");
            default:
                System.out.println("Invalid choice!");
        }
    }
    
    @Override
    protected void monsterTurn(Hero hero, Monster monster) throws LowHealthException {
        System.out.println();
        int damage = monster.getAttackStrategy().attack(monster, hero);
        hero.takeDamage(damage);
        System.out.println("Your HP: " + hero.getHealth());
    }
    
    @Override
    protected void battleEnd(Hero hero, Monster monster) {
        System.out.println("\n" + "=".repeat(40));
            if (hero.isAlive()) {
            System.out.println("🎉 VICTORY! " + monster.getName() + " defeated!");
        } else {
            System.out.println("💀 DEFEAT! You died...");
        }
        System.out.println("=".repeat(40) + "\n");
    }
}