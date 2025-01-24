package skin;

import enums.*;

public class Skin {
    private String name;
    private Sex sex;
    private boolean available = true;
    private int price;
    private byte numberOfLives = 3;
    private int points = 0;
    private Status status = Status.RESTING;
    private boolean[] accessories = {false, false, false};  //[1] = sword , [2] = gun , [3] = rope
    private int id;
    public static int idNext = 0;

    public Skin(String name, Sex sex, int price)
    {
        this.name = name;
        this.sex = sex;
        this.price = price;
        id = idNext;
        idNext++;
    }

    public boolean loseLife()
    {
        if (this.numberOfLives > 1)
        {
            this.numberOfLives--;
            return true;
        }
        else if (this.numberOfLives == 1)
        {
            this.numberOfLives--;
            setAvailable(false);
            return true;
        }
        else
            return false;
    }

    public boolean increaseLife()
    {
        return false;
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
