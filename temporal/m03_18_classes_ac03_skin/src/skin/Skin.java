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
        if (isAvailable())
        {
            if (this.numberOfLives < 5)
            {
                this.numberOfLives++;
                return true;
            }
        }

        return false;
    }

    public boolean resting()
    {
        if (isAvailable())
        {
            setStatus(Status.RESTING);
            return true;
        }

        return false;
    }

    public boolean battling()
    {
        boolean anyAccessorie = false;

        if (isAvailable())
        {
            for (boolean accessory : this.accessories)
                if (accessory)
                    anyAccessorie = true;

            if (anyAccessorie)
            {
                setStatus(Status.BATTLING);
                return true;
            }
        }

        return false;
    }

    public boolean eating()
    {
        if (isAvailable())
        {
            setStatus(Status.EATING);
            return true;
        }

        return false;
    }

    public boolean increasePoints(int points)
    {
        if (isAvailable())
        {
            this.points += points;
            return true;
        }

        return false;
    }

    public boolean decreasePoints(int points)
    {
        if (isAvailable())
        {
            if (points > this.points)
                setPoints(0);
            else
                this.points -= points;

            return true;
        }

        return false;
    }

    public boolean getSword()
    {
        if (isAvailable() && !accessories[0])
        {
            accessories[0] = true;
            return true;
        }

        return false;
    }

    public boolean getGun()
    {
        if (isAvailable() && !accessories[1])
        {
            accessories[1] = true;
            return true;
        }

        return false;
    }

    public boolean getRope()
    {
        if (isAvailable() && !accessories[2])
        {
            accessories[2] = true;
            return true;
        }

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

    @Override
    public String toString()
    {
        return String.format("Skin [name=%s, sex=%s, availability=%b, price=%d, numberOfLives=%d, points=%d, status=%s, accessoris=[%b, %b, %b]]",
                this.name, this.sex, this.available, this.price, this.numberOfLives, this.points, this.status, this.accessories[0], this.accessories[1], this.accessories[2]);
    }
}
