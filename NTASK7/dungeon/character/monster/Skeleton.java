package dungeon.character.monster;

public class Skeleton extends Monster {
    public Skeleton() {
        super("Skeleton", 70, 18, 5);
    }

    @Override
    public int getReward() {
        return 15;
    }
}