package observer;

public class GameLog implements GameObserver {
    @Override
    public void onHealthChanged(String name, int oldHp, int newHp) {
        System.out.println("[LOG] " + name + " HP: " + oldHp + " → " + newHp);
    }
    
    @Override
    public void onAttackChanged(String name, int newAttack) {
        System.out.println("[LOG] " + name + " attack increased to " + newAttack);
    }
    
    @Override
    public void onDefenseChanged(String name, int newDefense) {
        System.out.println("[LOG] " + name + " defense increased to " + newDefense);
    }
    
    @Override
    public void onEvent(String event) {
        System.out.println("[LOG] " + event);
    }
}