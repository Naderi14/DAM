package client;

public class Client {
    private String accountNum;
    private String name;
    private String surname;
    private String nationality = "ES";
    private String phone = "NOT_PROVIDED";
    private String dni;
    private byte age = 18;
    private float debts = 0;
    private boolean active = true;

    public Client(String accountNum, String name, String surname, String nationality, String phone, String dni, byte age)
    {
        this.accountNum = accountNum;
        this.name = name;
        this.surname = surname;
        this.nationality = nationality;
        this.phone = phone;
        this.dni = dni;
        this.age = age;
    }

    public Client(String accountNum, String name, String surname, String dni)
    {
        this.accountNum = accountNum;
        this.name = name;
        this.surname = surname;
        this.dni = dni;
    }

    public String getAccount()
    {
        return this.accountNum;
    }

    public void setAccount(String accountNum)
    {
        this.accountNum = accountNum;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return this.surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getNationality()
    {
        return this.nationality;
    }

    public void setNationality(String nationality)
    {
        this.nationality = nationality;
    }

    public String getPhone()
    {
        return this.phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getDni()
    {
        return this.dni;
    }

    public void setDni(String dni)
    {
        this.dni = dni;
    }

    public byte getAge()
    {
        return this.age;
    }

    public void setAge(byte age)
    {
        this.age = age;
    }

    public float getDebts()
    {
        return this.debts;
    }

    public void setDebts(float debts)
    {
        this.debts = debts;
    }

    public boolean isActive()
    {
        return this.active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    @Override
    public String toString()
    {
        return "Client [accountNum=" + this.accountNum + ", name=" + this.name +
                ", surname=" + this.surname + ", nationality=" + this.nationality +
                " , phone=" + this.phone + ", dni=" + this.dni + ", age=" + this.age +
                ", debts=" + this.debts + ", active=" + this.active + "]";
    }

    public boolean cancelDebts()
    {
        if (this.active)
        {
            this.debts = 0;
            return true;
        }

        return false;
    }

    public boolean cancelDebts2()
    {
        return false;
    }

    public boolean reduceDebts(float debts)
    {
        if (this.active)
        {
            if (debts < 0)
                return false;

            if (debts >= this.debts)
            {
                this.debts = 0;
                return true;
            }

            this.debts -= debts;
            return true;
        }

        return false;
    }

    public boolean reduceDebts2(float debts)
    {
        return false;
    }

    public boolean increaseDebts(float debts)
    {
        if (this.active && debts >= 0)
        {
            this.debts += debts;
            return true;
        }

        return false;
    }

    public boolean increaseDebts2(float debts)
    {
        return false;
    }
}
