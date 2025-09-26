import java.util.Scanner;

public class Maze {

    static class MazeGame {
        private int posX = 0;
        private int posY = 0;
        private final char[][] maze = {
            {'#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', '#', ' ', '#', '#'},
            {'#', ' ', '#', 'E', ' ', ' ', '#'},
            {'#', ' ', '#', '#', '#', ' ', '#'},
            {'#', 'P', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#'}
        };

        public void startPos() {
            for (int i = 0; i < maze.length; i++) {
                for (int j = 0; j < maze[i].length; j++) {
                    if (maze[i][j] == 'P') {
                        posX = i;
                        posY = j;
                    }
                }
            }
        }

        public int getPosX() {
            return posX;
        }

        public int getPosY() {
            return posY;
        }
    }

    static class UserInput {
        private final Scanner scanner;

        UserInput(Scanner scanner) {
            this.scanner = scanner;
        }

        public String getInput() {
            return scanner.next();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MazeGame game = new MazeGame();
        UserInput user = new UserInput(scan);

        game.startPos();

        boolean isGame = true;
        while (isGame) {
            System.out.print("Enter command: ");
            String command = user.getInput();
            System.out.println("You entered: " + command);

            if (command.equals("q")) {
                isGame = false;
            }
        }
    }
}
