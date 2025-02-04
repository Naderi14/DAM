package juanFranciscoExcepcionesExamen;

public class NumberNotValidException extends Exception 
{
	public static final String ERROR = "Number not valid";
	
	@Override
	public String getMessage()
	{
		return ERROR;
	}
}
