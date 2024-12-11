public class Exceptions {
    public static void main(String[] args) {
        Exceptions exceptions = new Exceptions();
        int power = exceptions.power(2, -5); // -5 valor inesperado
        System.out.println("power: " + power);
    }

    public int power(int base, int exp)
    {
        int result = 1;
        for (int i = 0; i < exp; i++)
        {
            result *= base;
        }
        return result;
    }
}
