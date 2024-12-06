package dungeonGame.effects;

import dungeonGame.Dungeon;
import dungeonGame.Monster;

import java.util.List;

public class DisappearMonsterEffect implements IEffect {
    public DisappearMonsterEffect (Monster monster)
    {
        System.out.println("<- Ha desaparecido un monstruo en (" + monster.getPosY() + "," + monster.getPosX() + ")");
    }

    public void aplicarEfecto()
    {

    }
}
