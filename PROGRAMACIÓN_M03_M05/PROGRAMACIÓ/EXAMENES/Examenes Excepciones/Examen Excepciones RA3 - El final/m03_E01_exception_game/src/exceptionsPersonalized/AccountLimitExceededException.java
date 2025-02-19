package exceptionsPersonalized;

public class AccountLimitExceededException extends Exception {
	public static final String ERROR = "Error: La puntuación máxima de la cuenta no puede superar los 1000 puntos";
	
	@Override
	public String getMessage()
	{
		return ERROR;
	}
}
