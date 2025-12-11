package dungeon.observer;

import dungeon.character.Character;

public interface Observer {
    void update(Character character);
}