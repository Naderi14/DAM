package exceptionsPersonalized;

public class InvalidAmountException extends Exception {
	public static final String ERROR = "Error: Los puntos a quitar deben ser mayor que cero";
	
	@Override
	public String getMessage()
	{
		return ERROR;
	}

}
