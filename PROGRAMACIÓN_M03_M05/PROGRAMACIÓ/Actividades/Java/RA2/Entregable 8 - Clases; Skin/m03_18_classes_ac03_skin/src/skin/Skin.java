package skin;

import enums.*;

public class Skin {
    private String name;
    private Sex sex;
    private boolean available;
    private int price;
    private byte numberOfLives;
    private int points;
    private Status status;
    private boolean[] accessories;
    private int id;
    public static int idNext;

    public Skin(String name, Sex sex)
    {
        this.name = name;
        this.sex = sex;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Sex getSex()
    {
        return sex;
    }

    public void setSex(Sex sex)
    {
        this.sex = sex;
    }

    public boolean isAvailable()
    {
        return available;
    }

    public void setAvailable(boolean available)
    {
        this.available = available;
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public byte getNumberOfLives()
    {
        return numberOfLives;
    }

    public void setNumberOfLives(byte numberOfLives)
    {
        this.numberOfLives = numberOfLives;
    }

    public int getPoints()
    {
        return points;
    }

    public void setPoints(int points)
    {
        this.points = points;
    }

    public Status getStatus()
    {
        return status;
    }

    public void setStatus(Status status)
    {
        this.status = status;
    }

    public boolean[] getAccessories()
    {
        return accessories;
    }

    public void setAccessories(boolean[] accessories)
    {
        this.accessories = accessories;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
}
