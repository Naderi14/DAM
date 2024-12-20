package effects;

import controllers.Dungeon;

public class AcrossWallEffect implements IEffect {
    public int probabilidad;

    public AcrossWallEffect(int probabilidad)
    {
        this.probabilidad = probabilidad;
    }

    public void aplicarEfecto(Dungeon dungeon)
    {
        dungeon.getPlayer().treasureEffect = this;
        System.out.println("<- Has cobrado una fuerza como para tumbar 1 muro ->");
    }

    public int getProbabilidad()
    {
        return probabilidad;
    }
}
