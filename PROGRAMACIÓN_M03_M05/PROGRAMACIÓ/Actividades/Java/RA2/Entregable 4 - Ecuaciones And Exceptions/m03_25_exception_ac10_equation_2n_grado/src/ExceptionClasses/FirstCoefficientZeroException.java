package ExceptionClasses;

public class FirstCoefficientZeroException extends Exception
{
    String message;

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
