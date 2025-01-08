package Exceptions;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MiException extends Exception {
    public static final int ERROR_0 = 0;
    public static final int ERROR_1 = 1;
    public static final int ERROR_2 = 2;

    public int value;
    private List<String> mensaje = Arrays.asList("Error numero 1", "Error numero 2", "Error numero 3");

    public MiException(int value)
    {
        this.value = value;
    }

    @Override
    public String getMessage()
    {
        return mensaje.get(value);
    }
}
