package battle;

import character.Hero;
import monster.Monster;
import monster.Dragon;
import exception.*;
import java.util.Scanner;

public abstract class BattleTemplate {
    protected Scanner scanner = new Scanner(System.in);
    
    
    public final void fight(Hero hero, Monster monster) {
        battleStart(hero, monster);
        
        while (hero.isAlive() && monster.isAlive()) {
            try {
                
                if (monster instanceof Dragon) {
                    Dragon dragon = (Dragon) monster;
                    try {
                        dragon.breathFire();
                    } catch (DragonFireException e) {
                        System.out.println(e.getMessage());
                        hero.takeDamage(e.getFireDamage());
                        System.out.println("Your HP: " + hero.getHealth());
                        continue;
                    }
                }
                
                
                heroTurn(hero, monster);
                
                if (!monster.isAlive()) break;
                
                
                monsterTurn(hero, monster);
                
            } catch (LowHealthException e) {
                System.out.println("⚰️  " + e.getMessage());
                break;
            }
        }
        
        battleEnd(hero, monster);
    }
    
    protected abstract void battleStart(Hero hero, Monster monster);
    protected abstract void heroTurn(Hero hero, Monster monster) throws LowHealthException;
    protected abstract void monsterTurn(Hero hero, Monster monster) throws LowHealthException;
    protected abstract void battleEnd(Hero hero, Monster monster);
}
