// src/main/java/com/dungeon/observer/UIObserver.java
package dungeon.observer;

import dungeon.character.Character;

public class UIObserver implements Observer {
    @Override
    public void update(Character character) {
        System.out.println("[UI] Updating display for " + character.getName());
    }
}