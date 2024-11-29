package rpgBattleWare;

public class Personaje
{
    public int vida, maxVida, energia, maxEnergia, mana, maxMana, fuerza, agilidad;
    public String nombrePnj;


    public Personaje(int maxVida, int maxEnergia, int maxMana, int fuerza, int agilidad, String nombrePnj)
    {
        this.maxVida = maxVida;
        vida = maxVida;
        this.maxEnergia = maxEnergia;
        energia = maxEnergia;
        this.maxMana = maxMana;
        mana = maxMana;
        this.fuerza = fuerza;
        this.agilidad = agilidad;
        this.nombrePnj = nombrePnj;
    }
}
