package player;
import enums.*;

public class Player {
    public static final int INITIAL_POINTS = 0;
    public static final byte INITIAL_AGE = 0;
    public static final byte MAX_CARDS = 0;

    private String name;
    private String surname;
    private float height;
    private float weight;
    private byte age;
    private int points;
    private boolean active;
    private byte cards;

    private Sex sex;
    private Team team;
    private Position position;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public float getHeight()
    {
        return height;
    }

    public void setHeight(float height)
    {
        this.height = height;
    }

    public float getWeight()
    {
        return weight;
    }

    public void setWeight(float weight)
    {
        this.weight = weight;
    }

    public byte getAge()
    {
        return age;
    }

    public void setAge(byte age)
    {
        this.age = age;
    }

    public int getPoints()
    {
        return points;
    }

    public void setPoints(int points)
    {
        this.points = points;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active) {

        this.active = active;
    }

    public byte getCards()
    {
        return cards;
    }

    public void setCards(byte cards)
    {
        this.cards = cards;
    }

    public Sex getSex()
    {
        return sex;
    }

    public void setSex(Sex sex)
    {
        this.sex = sex;
    }

    public Team getTeam()
    {
        return team;
    }

    public void setTeam(Team team)
    {
        this.team = team;
    }

    public Position getPosition()
    {
        return position;
    }

    public void setPosition(Position position)
    {
        this.position = position;
    }
}
