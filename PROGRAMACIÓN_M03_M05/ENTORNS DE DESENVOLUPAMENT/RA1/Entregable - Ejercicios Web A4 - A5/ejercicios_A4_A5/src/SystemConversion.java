import java.util.Scanner;

// ACTIVIDAD 4

public class SystemConversion {
    public static void main(String[] args) {

        SystemConversion sc = new SystemConversion();
        //1     1     1    1    1    1    1    1   1   1  1  1  1 1 1 1
        //32768 16384 8192 4096 2048 1024 512  256 128 64 32 16 8 4 2 1

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a binary number (0000000000000000-1111111111111111): ");
        String binary16 = scanner.nextLine();

        System.out.println("Decimal: " + sc.binaryToDecimal(binary16));

        scanner.close();
    }

    public long binaryToDecimal (String binary) {
        long number = Long.parseLong(binary);
        //1st
        int pos1 = digitPisition(number, 1);
        //2nd
        int pos2 = digitPisition(number, 2);
        //3rd
        int pos3 = digitPisition(number, 3);
        //4th
        int pos4 = digitPisition(number, 4);
        //5th
        int pos5 = digitPisition(number, 5);
        //6th
        int pos6 = digitPisition(number, 6);
        //7th
        int pos7 = digitPisition(number, 7);
        //8th
        int pos8 = digitPisition(number, 8);
        // 9th
        int pos9 = digitPisition(number, 9);
        // 10th
        int pos10 = digitPisition(number, 10);
        // 11th
        int pos11 = digitPisition(number, 11);
        // 12th
        int pos12 = digitPisition(number, 12);
        // 13th
        int pos13 = digitPisition(number, 13);
        // 14th
        int pos14 = digitPisition(number, 14);
        // 15th
        int pos15 = digitPisition(number, 15);
        // 16th
        int pos16 = digitPisition(number, 16);

        if ((pos1 != 0 && pos1 != 1)
                || (pos2 != 0 && pos2 != 1)
                || (pos3 != 0 && pos3 != 1)
                || (pos4 != 0 && pos4 != 1)
                || (pos5 != 0 && pos5 != 1)
                || (pos6 != 0 && pos6 != 1)
                || (pos7 != 0 && pos7 != 1)
                || (pos8 != 0 && pos8 != 1)
                || (pos9 != 0 && pos9 != 1)
                || (pos10 != 0 && pos10 != 1)
                || (pos11 != 0 && pos11 != 1)
                || (pos12 != 0 && pos12 != 1)
                || (pos13 != 0 && pos13 != 1)
                || (pos14 != 0 && pos14 != 1)
                || (pos15 != 0 && pos15 != 1)
                || (pos16 != 0 && pos16 != 1)
        ) return -1;

        double total =
                        pos1 * Math.pow(2, 0) +
                        pos2 * Math.pow(2, 1) +
                        pos3 * Math.pow(2, 2) +
                        pos4 * Math.pow(2, 3) +
                        pos5 * Math.pow(2, 4) +
                        pos6 * Math.pow(2, 5) +
                        pos7 * Math.pow(2, 6) +
                        pos8 * Math.pow(2, 7) +
                        pos9 * Math.pow(2, 8) +
                        pos10 * Math.pow(2, 9) +
                        pos11 * Math.pow(2, 10) +
                        pos12 * Math.pow(2, 11) +
                        pos13 * Math.pow(2, 12) +
                        pos14 * Math.pow(2, 13) +
                        pos15 * Math.pow(2, 14) +
                        pos16 * Math.pow(2, 15);

        return (long)total;
    }


    /**
     * Get the digit of a number given the position
     *
     * @param number   is a int
     * @param position is a int
     * @return the digit of position of a number
     */
    public int digitPisition(long number, int position)
    {
        double d1 = Math.pow(10, position);
        double d2 = Math.pow(10, position - 1);
        double d3 = (number % d1) / d2;

        //return (int) Math.abs(d3);
        return (int)d3;
    }
}
