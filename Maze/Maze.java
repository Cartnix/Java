public class Maze {

    private int PlayerX = 1;
    private int PlayerY = 1;
    private int ExitX;
    private int ExitY;
    private int MonsterX = 3;
    private int MonsterY = 3;

    private final char[][] maze = {
            {'#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', '#', ' ', '#', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', ' ', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', '#', 'E', '#'},
            {'#', '#', '#', '#', '#', '#', '#'}
    };

    public Maze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 'E') {
                    ExitX = i;
                    ExitY = j;
                }
            }
        }
    }

    public boolean movePlayer(char direction, Player player) {
        int newX = PlayerX;
        int newY = PlayerY;

        switch (direction) {
            case 'w': newX--; break;
            case 's': newX++; break;
            case 'a': newY--; break;
            case 'd': newY++; break;
        }

        char target = maze[newX][newY];

        if (newX == MonsterX && newY == MonsterY) {
            System.out.println("👾 Вы встретили монстра!");
            Monster monster = new Monster(1);
            Battle battle = new Battle(player, monster);
            battle.start();
            if (monster.getMonsterHP() <= 0) {
                MonsterX = -1;
                MonsterY = -1;
                PlayerX = newX;
                PlayerY = newY;
            }
        } else if (target == '#') {
            player.damaged(20);
            System.out.println("💥 Ударились о стену! -20 HP. Осталось: " + player.getPlayerHP());
        } else if (target == 'E') {
            System.out.println("🎉 Победа! Вы дошли до выхода!");
            return true;
        } else {
            PlayerX = newX;
            PlayerY = newY;
        }

        return false;
    }

    public void printMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (i == PlayerX && j == PlayerY) {
                    System.out.print("P ");
                } else if (i == MonsterX && j == MonsterY) {
                    System.out.print("M ");
                } else {
                    System.out.print(maze[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
