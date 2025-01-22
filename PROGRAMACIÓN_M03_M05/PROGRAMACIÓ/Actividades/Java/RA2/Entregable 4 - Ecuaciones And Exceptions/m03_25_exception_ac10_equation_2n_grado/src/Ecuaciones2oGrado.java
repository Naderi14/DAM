import ExceptionClasses.FirstCoefficientZeroException;
import ExceptionClasses.NoRealRootsException;

public class Ecuaciones2oGrado
{
    public double[] roots(double cofA, double cofB, double cofC) throws NoRealRootsException, FirstCoefficientZeroException {
        // No he pedido los valores aqui

        if (cofA == 0)
            throw new FirstCoefficientZeroException("We can't divide by zero!");

        double discriminant = Math.pow(cofB, 2) - 4 * cofA * cofC;

        if (discriminant > 0)
        {
            double solucion1 = (-cofB + Math.sqrt(discriminant)) / 2 * cofA;
            double solucion2 = (-cofB - Math.sqrt(discriminant)) / 2 * cofA;

            return new double[] {solucion1, solucion2};
        }
        else if (discriminant == 0)
        {
            double solucion1 = (-cofB + Math.sqrt(discriminant)) / 2 * cofA;

            return new double[] {solucion1};

        }
        else
        {
            throw new NoRealRootsException("No real roots.");
        }
    }
}
