package dungeon.character.monster;

public class Goblin extends Monster {
    public Goblin() {
        super("Goblin", 50, 15, 3);
    }

    @Override
    public int getReward() {
        return 10;
    }
}