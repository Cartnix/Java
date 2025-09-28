public class Player {
    private int PlayerHP = 100;
    private int PlayerAttack = 5;
    private int PlayerXP = 0;
    private int PlayerLevel = 1;

    public int getPlayerHP() { return PlayerHP; }

    public void heal() {
        PlayerHP += 10;
        if (PlayerHP > 100) PlayerHP = 100;
    }

    public int getPlayerDamage() { return PlayerAttack; }

    public void damaged(int damage) {
        PlayerHP -= damage;
        if (PlayerHP < 0) PlayerHP = 0;
    }

    public int getPlayerXP() { return PlayerXP; }

    public void addXP( int XP ){ PlayerXP += XP; }

    public int getPlayerLevel() { return PlayerLevel; }

    public void levelUp() {
        if (PlayerXP >= 100) {
            PlayerXP -= 100;
            PlayerLevel += 1;
        }
    }
}
