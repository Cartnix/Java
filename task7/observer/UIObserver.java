package observer;

public class UIObserver implements GameObserver {
    @Override
    public void onHealthChanged(String name, int oldHp, int newHp) {
        System.out.println("[UI] ❤️ " + name + ": " + newHp + " HP");
    }
    
    @Override
    public void onAttackChanged(String name, int newAttack) {
        System.out.println("[UI] ⚔️ " + name + " attack: " + newAttack);
    }
    
    @Override
    public void onDefenseChanged(String name, int newDefense) {
        System.out.println("[UI] 🛡️ " + name + " defense: " + newDefense);
    }
    
    @Override
    public void onEvent(String event) {
        System.out.println("[UI] 📢 " + event);
    }
}