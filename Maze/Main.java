import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player("Hero", 100);
        Maze maze = new Maze();

        boolean win = false;
        while (!win && player.getPlayerHP() > 0) {
            maze.printMaze();
            System.out.println("Введите ход (w/a/s/d): ");
            char move = scanner.next().charAt(0);

            win = maze.movePlayer(move, player);
        }

        if (player.getPlayerHP() <= 0) {
            System.out.println("☠️  Вы погибли!");
        } else {
            System.out.println("🎉 Игра пройдена!");
        }
    }
}
