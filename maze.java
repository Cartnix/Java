import java.util.Scanner;

public class maze {

    static class Monster {
        private int Healt = 10;
        private int Attack = 3;
        private count = 1;

        public int getHealth(){
            return this.Health;
        }

        public int getAttack(){
            return this.Attack;
        }
    }

    static class Player {
        private int Health = 100;
        private int Attack = 10;
        private int XP = 0;
        private int Level = 1;

        public int getHealth(){
            return this.Health;
        }

        public void setHealth(int newHP){
            this.Health = newHP;
        }

        public int getAttack(){
            return this.Attack;
        }

        public int getXp(){
            return this.XP;
        }

        public int getLevel(){
            return this.Level;
        }

        public void Heal(){
            this.Health += 20;
            if(this.Health > 100)
            {
                this.Health = 100;
            }
        }

        public void Run(){
            System.out.print("You runned away! Game is over");
            return;
        }
    }

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

        public boolean canMove(int newX, int newY){
            if(newX < 0 || newX >= maze.length || newY < 0 || newY >= maze[0].length){
                return false;
            }
            return maze[newX][newY] != '#';
        }

        public void tiles(int newX, int newY, Player player){
            if(maze[newX][newY] == '#'){
                player.setHealth(player.getHealth() - 20);
            } else if(maze[newX][newY] == 'E'){
                System.out.print("You win!");
                return;
            } else if(maze[newX][newY] == 'M'){

            }
        }

        public int getPosX() {
            return posX;
        }

        public int getPosY() {
            return posY;
        }

        public void setPosX(int newX) {
            posX = newX;
        }

        public void setPosY(int newY) {
            posY = newY;
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
        Player player = new Player();

        game.startPos();

        boolean isGame = true;
        while (isGame) {
            System.out.print("Enter command: ");
            String command = user.getInput();
            System.out.println("You entered: " + command);

            if (command.equals("q")) {
                isGame = false;
                System.out.print("You left the game!");
                return;
            }

            switch(command){
                case "W":
                case "w":
                    game.setPosX(game.getPosX() - 1);
                    break;
                case "S":
                case "s": 
                    game.setPosX(game.getPosX() + 1);
                    break;
                case "A":
                case "a":
                    game.setPosY(game.getPosY() - 1);
                    break;
                case "D":
                case "d":
                    game.setPosY(game.getPosY() + 1);
                    break;
                default: 
                    System.err.print("Вы ввели неверную команду!");

            }
        }
    }
}
