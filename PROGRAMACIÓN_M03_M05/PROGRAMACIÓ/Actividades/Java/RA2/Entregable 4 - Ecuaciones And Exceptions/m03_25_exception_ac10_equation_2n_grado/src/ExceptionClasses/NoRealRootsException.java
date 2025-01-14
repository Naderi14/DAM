package ExceptionClasses;

public class NoRealRootsException extends Exception
{
    String message;

    public NoRealRootsException(String message)
    {
        this.message = message;
    }

    @Override
    public String getMessage()
    {
        return message;
    }
}
