package ExceptionClasses;

public class FirstCoefficientZeroException extends Exception
{
    private final String message;

    public FirstCoefficientZeroException(String message)
    {
        this.message = message;
    }

    @Override
    public String getMessage()
    {
        return message;
    }
}
