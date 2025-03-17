package pokemon;

public class Pokemon {
    private int code;
    private String name;
    private String type1;
    private String type2;
    private int healthPoints;
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;
    private int speed;
    private byte generation;
    private boolean legendary;

    public Pokemon(int code, String name, String type1, String type2, int healthPoints, int attack, int defense, int specialAttack, int specialDefense, int speed, byte generation, boolean legendary) {
        this.code = code;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.healthPoints = healthPoints;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
        this.generation = generation;
        this.legendary = legendary;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public void setSpecialDefense(int specialDefense) {
        this.specialDefense = specialDefense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public byte getGeneration() {
        return generation;
    }

    public void setGeneration(byte generation) {
        this.generation = generation;
    }

    public boolean isLegendary() {
        return legendary;
    }

    public void setLegendary(boolean legendary) {
        this.legendary = legendary;
    }

    @Override
    public String toString()
    {
        if (type2.isEmpty())
            return String.format("[ %s ]\nType: %s | HP: %-3s | Attack: %-3s | Defense: %-3s\n" +
                    "Sp.Attack: %-3s | Sp.Defense: %-3s | Speed: %-3s | Gen: %-1s | Legendary: %s",
                    name, type1, healthPoints, attack, defense, specialAttack, specialDefense, speed, generation, legendary);
        else
            return String.format("[ %s ]\nType: %s, %s | HP: %-3s | Attack: %-3s | Defense: %-3s\n" +
                            "Sp.Attack: %-3s | Sp.Defense: %-3s | Speed: %-3s | Gen: %-1s | Legendary: %s",
                    name, type1, type2, healthPoints, attack, defense, specialAttack, specialDefense, speed, generation, legendary);
    }
}
