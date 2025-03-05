package skin;

import skin.enums.Modes;

public class Mode {
    private Modes modeName;
    private Skin[] skins;
    private Zombi[] zombis;

    public Mode(Modes modeName, Skin[] skins, int zombis)
    {
        this.modeName = modeName;
        this.skins = skins;
        this.zombis = new Zombi[zombis];

        for (int i = 0; i < zombis; i++)
        {
            this.zombis[i] = new Zombi(i);
        }
    }

    public Modes getModeName()
    {
        return modeName;
    }

    public void setModeName(Modes modeName)
    {
        this.modeName = modeName;
    }

    public Skin[] getSkins()
    {
        return skins;
    }

    public void setSkins(Skin[] skins)
    {
        this.skins = skins;
    }

    public Zombi[] getZombis()
    {
        return zombis;
    }

    public void setZombis(Zombi[] zombis)
    {
        this.zombis = zombis;
    }

    @Override
    public String toString()
    {
        return String.format("Mode [modeName=%s, skins=%s, zombis=%s]", this.modeName, this.skins.toString(), this.zombis.toString());
    }
}
