package classes;

public class Bank {
    private String name;
    private String swiftCode;

    public Bank(String swiftCode, String name)
    {
        this.swiftCode = swiftCode;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    @Override
    public String toString()
    {
        return String.format("Bank [name=%s, swiftCode=%s]\n", this.name, this.swiftCode);
    }
}
