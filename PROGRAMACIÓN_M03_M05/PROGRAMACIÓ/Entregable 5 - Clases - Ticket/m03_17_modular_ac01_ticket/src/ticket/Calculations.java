package ticket;

import java.util.Date;

// TODO: OK

public class Calculations {
    static float round(float num, byte decimals)
    {
        num = Math.round(num * (decimals * 10)) / (float)(decimals * 10);
        return num;
    }

    static String generateDate()
    {
        Date date = new Date();
        return String.format("%1td.%1$tm.%1$ty", date);
    }

    static String generateTime()
    {
        Date date = new Date();
        return String.format("%tT", date);
    }
}
