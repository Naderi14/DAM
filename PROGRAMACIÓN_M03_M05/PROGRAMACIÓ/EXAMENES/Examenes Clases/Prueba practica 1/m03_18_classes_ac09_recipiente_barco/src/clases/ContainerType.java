package clases;

public enum ContainerType {
    STANDARD ("Standard Type"),
    FREEZE ("Refrigerated"),
    TANK ("Liquid Tank"),
    OPEN_TOP ("No ceiling");

    private String description;

    private ContainerType(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }
}
