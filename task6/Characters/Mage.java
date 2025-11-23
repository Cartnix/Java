package characters;

import strategies.MagicAttack;

public class Mage extends Character {
    public Mage(String name) {
        super(name, 80);
        this.attackStrategy = new MagicAttack();
    }
}
