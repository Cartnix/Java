package observer;

public class BattleLog implements GameObserver {
    @Override
    public void onEvent(String event) {
        System.out.println("[LOG] " + event);
    }
}