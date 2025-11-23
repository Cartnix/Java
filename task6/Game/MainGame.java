package game;

import characters.*;
import factories.*;
import observers.BattleLog;

import java.util.Random;
import java.util.Scanner;

public class MainGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите класс персонажа:");
        System.out.println("1. Warrior");
        System.out.println("2. Mage");
        System.out.println("3. Archer");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Введите имя персонажа: ");
        String name = scanner.nextLine();

        CharacterFactory factory;
        switch (choice) {
            case 1 -> factory = new WarriorFactory();
            case 2 -> factory = new MageFactory();
            case 3 -> factory = new ArcherFactory();
            default -> {
                System.out.println("Неверный выбор, создаем Warrior по умолчанию.");
                factory = new WarriorFactory();
            }
        }

        characters.Character player = factory.createCharacter(name);
        characters.Warrior enemy = new characters.Warrior("Враг");

        BattleLog log = new BattleLog();
        player.addObserver(log);
        enemy.addObserver(log);

        Random random = new Random();
        System.out.println("Бой начинается!");

        while (player.isAlive() && enemy.isAlive()) {
            if (random.nextBoolean()) {
                player.performAttack(enemy);
            } else {
                enemy.performAttack(player);
            }

            System.out.println(player.getName() + " HP: " + player.getHealth());
            System.out.println(enemy.getName() + " HP: " + enemy.getHealth());
            System.out.println("-----------------------");

            try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
        }

        if (player.isAlive()) {
            System.out.println(player.getName() + " победил!");
        } else {
            System.out.println(enemy.getName() + " победил!");
        }
    }
}
