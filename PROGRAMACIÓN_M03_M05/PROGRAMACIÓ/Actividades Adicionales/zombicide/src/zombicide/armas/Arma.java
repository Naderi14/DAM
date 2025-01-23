package zombicide.armas;

public class Arma {
    private String nombre;
    private int damage;
    private int alcance;
    private int acierto;

    public Arma(String nombre, int damage, int alcance, int acierto)
    {
        this.nombre = nombre;
        this.damage = damage;
        this.alcance = alcance;
        this.acierto = acierto;
    }

    public void ataqueEspecial()
    {
        
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public int getDamage()
    {
        return this.damage;
    }

    public int getAlcance()
    {
        return this.alcance;
    }

    public int getAcierto()
    {
        return this.acierto;
    }
}
