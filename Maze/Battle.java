public class Battle {
    private Player player;
    private Monster monster;

    public Battle(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
    }

    public void start() {
        System.out.println("⚔️ Битва началась! Игрок vs Монстр (LVL " + monster.getMonsterLevel() + ")");

        while (player.getPlayerHP() > 0 && monster.getMonsterHP() > 0) {
            monster.monsterDamaged(player.getPlayerDamage());
            System.out.println("Игрок ударил, у монстра осталось: " + monster.getMonsterHP() + " HP");

            if (monster.getMonsterHP() <= 0) {
                System.out.println("Монстр повержен!");
                player.addXP(50);
                break;
            }

            player.damaged(monster.getMonsterAttack());
            System.out.println("Монстр ударил, у игрока осталось: " + player.getPlayerHP() + " HP");

            if (player.getPlayerHP() <= 0) {
                System.out.println("Игрок погиб...");
                break;
            }
        }
    }
}
