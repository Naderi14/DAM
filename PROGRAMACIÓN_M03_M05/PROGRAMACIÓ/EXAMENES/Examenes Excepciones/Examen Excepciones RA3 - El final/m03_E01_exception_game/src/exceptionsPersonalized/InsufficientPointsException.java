package exceptionsPersonalized;

public class InsufficientPointsException extends Exception {
	public static final String ERROR = "Error: Puntos insuficientes para realizar la acción.";
	
	@Override
	public String getMessage()
	{
		return ERROR;
	}
}
