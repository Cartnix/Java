import character.Character;
import factory.*;
import observer.BattleLog;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static BattleLog battleLog = new BattleLog();

    public static void main(String[] args) {
        System.out.println("⚔️ Добро пожаловать в мини-RPG!");
        System.out.println("Выберите героя:");
        System.out.println("1 - Воин (HP: 100, атака мечом 15 урона)");
        System.out.println("2 - Маг (HP: 80, магия 20 урона, -5 HP себе)");
        System.out.println("3 - Лучник (HP: 90, стрела 10 урона, 30% крит 25)");
        System.out.println("4 - Ассасин (HP: 75, кинжал 12 урона, 40% бэкстаб 30)");
        System.out.println("5 - Берсерк (HP: 110, ярость 22 урона, -3 HP себе)");

        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введите имя героя: ");
        String heroName = scanner.nextLine();

        CharacterFactory factory = getFactory(choice);
        Character hero = factory.createCharacter(heroName);
        hero.addObserver(battleLog);

        Character enemy = createRandomEnemy();
        enemy.addObserver(battleLog);

        System.out.println("\nБой начинается: " + hero.getName() + " [HP=" + hero.getHealth() + 
                          "] VS " + enemy.getName() + " [HP=" + enemy.getHealth() + "]\n");

        Random random = new Random();
        while (hero.isAlive() && enemy.isAlive()) {
            if (random.nextBoolean()) {
                hero.performAttack(enemy);
                if (!enemy.isAlive()) {
                    battleLog.onEvent(enemy.getName() + " погиб.");
                }
            } else {
                enemy.performAttack(hero);
                if (!hero.isAlive()) {
                    battleLog.onEvent(hero.getName() + " погиб.");
                }
            }

            System.out.println(hero.getName() + " [HP=" + hero.getHealth() + "] | " + 
                             enemy.getName() + " [HP=" + enemy.getHealth() + "]\n");

            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n🏆 ============= ИТОГ БОЯ =============");
        if (hero.isAlive()) {
            System.out.println("🎉 ПОБЕДА! " + hero.getName() + " одержал победу с " + hero.getHealth() + " HP!");
        } else {
            System.out.println("💀 ПОРАЖЕНИЕ! " + enemy.getName() + " победил с " + enemy.getHealth() + " HP!");
        }
        
        scanner.close();
    }

    private static CharacterFactory getFactory(int choice) {
        switch (choice) {
            case 1: return new WarriorFactory();
            case 2: return new MageFactory();
            case 3: return new ArcherFactory();
            case 4: return new AssassinFactory();
            case 5: return new BerserkerFactory();
            default: return new WarriorFactory();
        }
    }

    private static Character createRandomEnemy() {
        Random random = new Random();
        String[] enemyNames = {"Злобный Орк", "Тёмный Маг", "Гоблин-Лучник", "Бандит", "Дикий Берсерк"};
        CharacterFactory[] factories = {
            new WarriorFactory(),
            new MageFactory(),
            new ArcherFactory(),
            new AssassinFactory(),
            new BerserkerFactory()
        };

        int index = random.nextInt(factories.length);
        return factories[index].createCharacter(enemyNames[index]);
    }
}