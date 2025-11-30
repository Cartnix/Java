package monster;

import strategy.MagicAttack;
import exception.DragonFireException;

public class Dragon extends Monster {
    public Dragon() {
        super("Dragon", 100, 15, new MagicAttack());
    }
    
    public boolean canUseFireBreath() {
        return health > 50;
    }

    public void breathFire() throws DragonFireException {
        if (canUseFireBreath()) {
            int fireDamage = getAttackPower() * 2;
            throw new DragonFireException("Dragon breathes fire!", fireDamage);
        }
        
    }
}