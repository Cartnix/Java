package dungeon.battle;

import dungeon.character.hero.Hero;
import dungeon.character.monster.Monster;
import dungeon.exception.DragonFireException;
import dungeon.exception.LowHealthException;

public abstract class BattleTemplate {
    public final void executeBattle(Hero hero, Monster monster) throws LowHealthException {
        startBattle(hero, monster);
        
        while (hero.isAlive() && monster.isAlive()) {
            heroTurn(hero, monster);
            
            if (!monster.isAlive()) {
                break;
            }
            
            monsterTurn(monster, hero);
            
            checkHealth(hero);
        }
        
        endBattle(hero, monster);
    }

    protected void startBattle(Hero hero, Monster monster) {
        System.out.println("\nBattle started: " + hero.getName() + " vs " + monster.getName());
    }

    protected void heroTurn(Hero hero, Monster monster) {
        int damage = hero.performAttack();
        monster.takeDamage(damage);
        System.out.println(hero.getName() + " attacks for " + damage + " damage!");
        System.out.println(monster.getName() + " HP: " + monster.getHealth());
    }

    protected void monsterTurn(Monster monster, Hero hero) {
        try {
            int damage = monster.performAttack();
            hero.takeDamage(damage);
            System.out.println(monster.getName() + " attacks for " + damage + " damage!");
            System.out.println(hero.getName() + " HP: " + hero.getHealth());
        } catch (DragonFireException e) {
            int fireDamage = monster.performAttack() * 2;
            hero.takeDamage(fireDamage);
            System.out.println(e.getMessage());
            System.out.println(hero.getName() + " takes " + fireDamage + " fire damage!");
            System.out.println(hero.getName() + " HP: " + hero.getHealth());
        }
    }

    protected void checkHealth(Hero hero) throws LowHealthException {
        if (!hero.isAlive()) {
            throw new LowHealthException("Hero has fallen in battle!");
        }
    }

    protected void endBattle(Hero hero, Monster monster) {
        if (hero.isAlive()) {
            System.out.println(hero.getName() + " won the battle!");
            System.out.println("Gained " + monster.getReward() + " experience!");
        } else {
            System.out.println(hero.getName() + " was defeated!");
        }
    }
}