package dungeon;

import dungeon.game.Game;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        System.out.println("Welcome to Dungeon Adventure!");
        System.out.print("Enter hero name: ");
        String name = scanner.nextLine();
        
        System.out.print("Choose hero type (1. Warrior/ 2. Mage/ 3. Archer): ");
        String type = scanner.nextLine();

        game.start(name, type);

        while (game.isGameActive()) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Fight next monster");
            System.out.println("2. View inventory");
            System.out.println("3. Use item");
            System.out.println("4. View remaining monsters");
            System.out.println("5. View leaderboard");
            System.out.println("6. Exit");
            System.out.print("Choose action: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    game.playRound();
                    break;
                case 2:
                    game.displayInventory();
                    break;
                case 3:
                    game.displayInventory();
                    System.out.print("Enter item index: ");
                    int itemIndex = scanner.nextInt();
                    scanner.nextLine();
                    game.useInventoryItem(itemIndex);
                    break;
                case 4:
                    game.displayRemainingMonsters();
                    break;
                case 5:
                    game.displayLeaderboard();
                    break;
                case 6:
                    System.out.println("Thanks for playing!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }
}