package effects;

import controllers.Dungeon;

public class SlowEffectCurse implements IEffect{
    private int probabilidad;
    private boolean canWalk;

    public SlowEffectCurse(int probabilidad)
    {
        this.probabilidad = probabilidad;
    }

    public void aplicarEfecto(Dungeon dungeon)
    {
            dungeon.getPlayer().levelDebuff = this;

        System.out.println("<- Al subir las escaleras, una piedra te ha contagiado artritis, vaya, irás mas lento ->\n");
        canWalk = false;
    }

    public int getProbabilidad()
    {
        return probabilidad;
    }

    public boolean tryWalk()
    {
        canWalk = !canWalk;
        return canWalk;
    }
}
