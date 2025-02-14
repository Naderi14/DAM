package exceptionsPersonalized;

public class InvalidDepositAmountException extends Exception {
	public static final String ERROR = "Error: Los puntos a depositar deben ser mayor que cero";
	
	@Override
	public String getMessage()
	{
		return ERROR;
	}
}
