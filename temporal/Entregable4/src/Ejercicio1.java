import java.util.Scanner;

public class Ejercicio1 {
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        int day, month, year;
        boolean bisiesto = false, isFebrero = false, mesLargo = false;

        while (true){
            System.out.println("Introduce el AÑO");
            year = leer.nextInt();
            if (year < 0){
                System.out.println("ERROR: El AÑO no puede ser anterior a cristo\n");
                continue;
            }

            if (year % 4 == 0)
                bisiesto = true;

            break;
        }

        while (true){
            System.out.println("Introduce el MES");
            month = leer.nextInt();
            if (month <= 0 || month > 12) {
                System.out.println("ERROR: El MES introducido no es correcto\n");
                continue;
            }

            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
                mesLargo = true;
            else if (month == 2) {
                isFebrero = true;
            }
            break;
        }

        while (true){
            System.out.println("Introduce el DIA");
            day = leer.nextInt();

            if (isFebrero) {
                if (bisiesto && day > 29){
                    System.out.println("ERROR: El DIA es superior a febrero bisiesto (1 - 29)");
                    continue;
                } else if (!bisiesto && day > 28) {
                    System.out.println("ERROR: El DIA es superior a febrero (1 - 28)");
                    continue;
                }
            }

            if (day <= 0 || day > 30){
                if (mesLargo && day > 31){
                    System.out.println("ERROR: El DIA es superior al mes largo (1 - 31)");
                    continue;
                } else if (!mesLargo) {
                    System.out.println("ERROR: El DIA es superior al mes corto (1 - 30)");
                    continue;
                }
            }
            break;
        }

        if (day < 10 && month > 9)
            System.out.println("Fecha Validada: 0" + day + "/" + month + "/" + year);
        else if (day > 9 && month < 10)
            System.out.println("Fecha Validada: " + day + "/0" + month + "/" + year);
        else if (day < 10 )
            System.out.println("Fecha Validada: 0" + day + "/0" + month + "/" + year);
        else
            System.out.println("Fecha Validada: " + day + "/" + month + "/" + year);

        switch (month)
        {
            case 1:
                System.out.println(day + " de Enero del " + year);
                break;
            case 2:
                System.out.println(day + " de Febrero del " + year);
                break;
            case 3:
                System.out.println(day + " de Marzo del " + year);
                break;
            case 4:
                System.out.println(day + " de Abril del " + year);
                break;
            case 5:
                System.out.println(day + " de Mayo del " + year);
                break;
            case 6:
                System.out.println(day + " de Junio del " + year);
                break;
            case 7:
                System.out.println(day + " de Julio del " + year);
                break;
            case 8:
                System.out.println(day + " de Agosto del " + year);
                break;
            case 9:
                System.out.println(day + " de Septiembre del " + year);
                break;
            case 10:
                System.out.println(day + " de Octubre del " + year);
                break;
            case 11:
                System.out.println(day + " de Noviembre del " + year);
                break;
            case 12:
                System.out.println(day + " de Diciembre del " + year);
                break;
            default:
                break;
        }
    }
}