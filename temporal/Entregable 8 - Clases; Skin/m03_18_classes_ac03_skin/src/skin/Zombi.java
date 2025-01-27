package skin;

public class Zombi {
    private int code;
    private int strength = 10;
    private boolean active = true;

    public Zombi(int code)
    {
        this.code = code;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    public int getStrength()
    {
        return strength;
    }

    public void setStrength(int strength)
    {
        this.strength = strength;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    @Override
    public String toString()
    {
        return String.format("Zombie [code=%d, strength=%d, active=%b]", this.code, this.strength, this.active);
    }
}
