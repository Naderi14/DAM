package player;

import player.enums.*;

import java.util.Objects;

public class Player {
    public static final int INITIAL_POINTS = 100;
    public static final byte INITIAL_AGE = 18;
    public static final byte MAX_CARDS = 2;

    private String name;
    private String surname;
    private float height;
    private float weight;
    private byte age;
    private int points;
    private boolean active;
    private byte cards = 0;

    private Sex sex;
    private Team team;
    private Position position;

    public Player(String name, String surname, float height, float weight, byte age, Sex sex, int points, Team team, Position position, boolean active) {
        this.name = name;
        this.surname = surname;
        this.height = height;
        this.weight = weight;
        if (age > INITIAL_AGE)
            this.age = age;
        if (points > INITIAL_POINTS)
            this.points = points;
        this.active = active;
        this.sex = sex;
        this.team = team;
        this.position = position;
    }

    public Player(String name, String surname, float height, float weight, Team team, Position position) {
        this.name = name;
        this.surname = surname;
        this.height = height;
        this.weight = weight;
        this.team = team;
        this.position = position;
        this.age = INITIAL_AGE;
        this.points = INITIAL_POINTS;
        this.active = true;
        this.sex = Sex.NOTDEFINED;
    }

    public Player(String name, String surname, Sex sex, Team team, Position position) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.team = team;
        this.position = position;
        this.age = INITIAL_AGE;
        this.points = INITIAL_POINTS;
        this.active = true;
    }

    public Player(String name, String surname, byte age, Sex sex, Team team, Position position) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
        this.team = team;
        this.position = position;
        this.points = INITIAL_POINTS;
        this.active = true;
    }

    @Override
    public String toString()
    {
        String stringOutput = String.format("PLAYER: %s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s",
                this.name, this.surname, this.height, this.weight, this.age, this.sex, this.points, this.team, this.position, this.active, this.cards);

        return stringOutput;
    }

    public boolean increasePoints(int points)
    {
        if (isActive() && points >= 0 && this.cards < MAX_CARDS)
        {
            this.points += points;
            return true;
        }

        return false;
    }

    public boolean decreasePoints(int points)
    {
        if (isActive() && points > 0 && this.cards < MAX_CARDS)
        {
            if (points > this.points)
                this.points = 0;
            else
                this.points -= points;

            return true;
        }

        return false;
    }

    public boolean giveCard()
    {
        if (isActive() && this.cards < MAX_CARDS)
        {
            if (++this.cards == MAX_CARDS)
                setActive(false);

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player player)) return false;
        return Float.compare(getHeight(), player.getHeight()) == 0 && getAge() == player.getAge() && Objects.equals(getName(), player.getName()) && Objects.equals(getSurname(), player.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getHeight(), getAge());
    }
}
