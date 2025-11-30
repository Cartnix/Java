package observer;

public interface GameObserver {
    void onHealthChanged(String name, int oldHp, int newHp);
    void onAttackChanged(String name, int newAttack);
    void onDefenseChanged(String name, int newDefense);
    void onEvent(String event);
}