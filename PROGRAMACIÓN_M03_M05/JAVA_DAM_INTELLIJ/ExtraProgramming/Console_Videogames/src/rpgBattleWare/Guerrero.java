package rpgBattleWare;

public class Guerrero extends Personaje
{
    public Guerrero(int maxVida, int maxEnergia, int maxMana, int fuerza, int agilidad, String nombrePnj) {
        super(maxVida, maxEnergia, maxMana, fuerza, agilidad, nombrePnj);
    }

    public void showStats()
    {
        System.out.println("Ademas de los especificos..");
    }
}
