import java.util.Scanner;

public class CalcularMenor {
    public static void main(String[] args)
    {
        CalcularMenor calcular = new CalcularMenor();
        calcular.menuPrincipal();
    }

    public void menuPrincipal()
    {
        System.out.println("<- Introduce 2 numeros ->");

        System.out.println("<- Número 1: ");
        int numero1 = this.pedirNumero();

        System.out.println("<- Número 2: ");
        int numero2 = this.pedirNumero();

        System.out.println("<- El número menor es " + calcularMenor(numero1, numero2));
    }

    public int pedirNumero()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public int calcularMenor(int numero1, int numero2)
    {
        return numero1 < numero2 ? numero1 : numero2;
    }
}
