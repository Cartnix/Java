package factory;

import monster.*;
import java.util.Random;

public class MonsterFactory {
    private static Random random = new Random();
    
    public static Monster createRandomMonster() {
        int type = random.nextInt(3);
        switch (type) {
            case 0: return new Goblin();
            case 1: return new Skeleton();
            case 2: return new Dragon();
            default: return new Goblin();
        }
    }
    
    public static Monster createBoss() {
        return new Dragon();
    }
}