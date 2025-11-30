package character;

import strategy.BerserkerAttack;

public class Berserker extends Character {
    public Berserker(String name) {
        super(name, 110, new BerserkerAttack());
    }
}