public class Bigger {
    public static int bigger(int[] array)
    {
        int index;
        int max = Integer.MIN_VALUE;

        if (array.length == 0)
        {
            throw new  NullPointerException("Empty list");
        }

        for (index = 0; index < array.length; index++)
        {
            if (array[index] > max)
            {
                max = array[index];
            }
        }

        return max;
    }
}
