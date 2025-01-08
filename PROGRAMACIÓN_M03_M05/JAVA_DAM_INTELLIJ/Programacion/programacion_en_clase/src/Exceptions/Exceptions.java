package Exceptions;

public class Exceptions {
    public static void main(String[] args) {
        Exceptions exceptions = new Exceptions();
        int power = 0;

        try
        {
            power = exceptions.power(-2, 5);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        System.out.println("power: " + power);

        System.out.println("OTRAS COSAS A PARTE");
        try{
            RaiseError0();
        } catch (MiException e) {
            System.out.println(e.getMessage());;
        }
        try{
            RaiseError1();
        } catch (MiException e) {
            System.out.println(e.getMessage());;
        }
        try{
            RaiseError2();
        } catch (MiException e) {
            System.out.println(e.getMessage());;
        }
    }

    public int power(int base, int exp) throws Exception
    {
        if (exp < 0)
            throw new Exception("El exponente no puede ser 0 o negativo");

        if (base < 0)
            throw new Exception("La base no puede ser negativo");

        int result = 1;
        for (int i = 0; i < exp; i++)
        {
            result *= base;
        }
        return result;
    }

    public static void RaiseError0() throws MiException
    {
        throw new MiException(MiException.ERROR_0);
    }

    public static void RaiseError1() throws MiException
    {
        throw new MiException(MiException.ERROR_1);
    }

    public static void RaiseError2() throws MiException
    {
        throw new MiException(MiException.ERROR_2);
    }
}
