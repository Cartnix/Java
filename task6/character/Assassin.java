package character;

import strategy.AssassinAttack;

public class Assassin extends Character {
    public Assassin(String name) {
        super(name, 75, new AssassinAttack());
    }
}